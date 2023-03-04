package com.edix.proyecto.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.edix.proyecto.beans.*;
import com.edix.proyecto.repository.PedidoRepository;
import com.edix.proyecto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edix.proyecto.utils.CarritoUtils;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
	@Autowired 
	CarritoService caService;

	@Autowired
	UsuarioServiceImpl uService;

	@Autowired
	PedidoRepository pRepo;

	@Autowired
	PedidoService pService;

	@Autowired
	TarjetaServiceImpl tService;

	@Autowired
	DireccionServiceImpl dService;

	@Autowired
	CarritoUtils caUtil;

	/**
	 * Comprobaremos si en la sesión hay un atributo Carrito y si lo hay devolveremos el mapa de productos y cantidades
	 * @return
	 */
	@GetMapping("")
	public String verProductosCarrito(Model model, HttpSession misesion) {
		caUtil.comprobaroCrearCarrito(misesion, model);
		
		return "Carrito";
	}
	
	/**
	 * Recupera el carrito en sesión y añade una unidad al producto pasado por parámetro
	 * @return
	 */
	@GetMapping("/añadirUno/{idProducto}")
	public String añadirUno(Model model,@PathVariable int idProducto,HttpSession misesion) {
				
		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		caService.sumarProductoEnCarrito(carrito, idProducto);
		
		return "redirect:/carrito";
	}
	
	/**
	 * Recupera el carrito en sesión y elimina una unidad del producto pasado por parámetro
	 * @return
	 */
	@GetMapping("/eliminarUno/{idProducto}")
	public String eliminarUno(Model model,@PathVariable int idProducto,HttpSession misesion) {
		
		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		caService.restarProductoEnCarrito(carrito, idProducto);
		
		return "redirect:/carrito";
	}
	
	@GetMapping("/guardar")
	public String guardarCarrito(Model model, HttpSession misesion) {
		
		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		Usuario user = (Usuario) misesion.getAttribute("sesion");
		
		caService.guardarCarrito(carrito, user);
		
		return "redirect:/carrito";
	}

	@GetMapping("/comprar")
	public String mostrarCompra(Model model, HttpSession misesion) {
		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		Usuario user = (Usuario) misesion.getAttribute("sesion");

		model.addAttribute("carrito", carrito);
		model.addAttribute("user", uService.buscarUsuario(user.getIdUsuario()));

		return "procesarCompra";
	}

	@PostMapping("/pagar")
	public String pagarCarrito(Model model, HttpSession misesion, @RequestParam("idDireccion") int idDireccion
																, @RequestParam("idTarjeta") int idTarjeta){

		Usuario user = (Usuario) misesion.getAttribute("sesion");
		Pedido pedido = pRepo.buscarPedidoCarritoPorCliente(user.getIdUsuario());

		Direccion dir = dService.buscarDireccion(idDireccion);
		Tarjeta tar = tService.buscarTarjeta(idTarjeta);

		if(pedido.getEstado().equals("CARRITO")) {
			pedido.setEstado("COMPLETADO");
			pedido.setDireccione(dir);
			pedido.setTarjeta(tar);
			pRepo.save(pedido);
			caService.eliminarCarrito(user.getIdUsuario());
			
			misesion.removeAttribute("carrito");
		}else {
			model.addAttribute("error", "No se ha podido realizar el pago");
			return "redirect:/procesarCompra";
		}
		return "paginaCompra";
	}

}
