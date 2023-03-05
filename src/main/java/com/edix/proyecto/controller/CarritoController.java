package com.edix.proyecto.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.edix.proyecto.beans.*;
import com.edix.proyecto.repository.PedidoRepository;
import com.edix.proyecto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edix.proyecto.utils.CarritoUtils;


@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
	@Autowired CarritoService caService;
	@Autowired UsuarioService uService;
	@Autowired PedidoRepository pRepo;
	@Autowired PedidoService pService;
	@Autowired ProductoService proService;
	@Autowired TarjetaService tService;
	@Autowired DireccionService dService;
	@Autowired CarritoUtils caUtil;

	/**
	 * Comprobaremos si en la sesión hay un atributo Carrito y si lo hay devolveremos el mapa de productos y cantidades
	 * @return Página JSP del carrito. "Carrito".
	 */
	@GetMapping("")
	public String verProductosCarrito(Model model, HttpSession misesion) {
		//Comprobamos si hay un carrito en la sesión
		caUtil.comprobaroCrearCarrito(misesion, model);
		return "Carrito";
	}
	
	/**
	 * Recupera el carrito en sesión y añade una unidad al producto pasado por parámetro
	 * @return Página JSP del carrito. "Carrito".
	 */
	@GetMapping("/añadirUno/{idProducto}")
	public String añadirUno(Model model,@PathVariable int idProducto,HttpSession misesion) {

		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		caService.sumarProductoEnCarrito(carrito, idProducto);
		
		return "redirect:/carrito";
	}
	
	/**
	 * Recupera el carrito en sesión y elimina una unidad del producto pasado por parámetro
	 * @return Página JSP del carrito. "Carrito".
	 */
	@GetMapping("/eliminarUno/{idProducto}")
	public String eliminarUno(Model model,@PathVariable int idProducto,HttpSession misesion) {

		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		caService.restarProductoEnCarrito(carrito, idProducto);
		
		return "redirect:/carrito";
	}

	/***
	 * Guardar el carrito que hay en la sesión del usuario.
	 * @param model para pasar datos a la vista
	 * @param HttpSession para recuperar la sesión del usuario actual
	 * @return Página JSP del carrito. "Carrito".
	 */
	@GetMapping("/guardar")
	public String guardarCarrito(Model model, HttpSession misesion) {
		
		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		Usuario user = (Usuario) misesion.getAttribute("sesion");
		//Comprobamos si el usuario tiene un carrito en la base de datos
		caService.guardarCarrito(carrito, user);
		
		return "redirect:/carrito";
	}

	/**
	 * Proceso de compra de un pedido por un usuario
	 * @param model
	 * @param HttpSession para recuperar la sesión del usuario que ha hecho el pedido.
	 * @return Página JSP del de proceso de compra.
	 */
	@GetMapping("/comprar")
	public String mostrarCompra(Model model, HttpSession misesion) {
		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		Usuario user = (Usuario) misesion.getAttribute("sesion");

		model.addAttribute("carrito", carrito);
		model.addAttribute("user", uService.buscarUsuario(user.getIdUsuario()));

		return "procesarCompra";
	}

	/**
	 * Proceso de pago del pedido de un usuario, a través de un formulario.
	 * @param model
	 * @param HttpSession para recuperar la sesión del usuario que ha hecho el pedido.
	 * @return Pagina JSP final de la compra del pedido.
	 */
	@PostMapping("/pagar")
	public String pagarCarrito(Model model, HttpSession misesion, @RequestParam("idDireccion") int idDireccion
																, @RequestParam("idTarjeta") int idTarjeta){

		Usuario user = (Usuario) misesion.getAttribute("sesion");
		Pedido pedido = pRepo.buscarPedidoCarritoPorCliente(user.getIdUsuario());

		Direccion dir = dService.buscarDireccion(idDireccion);
		Tarjeta tar = tService.buscarTarjeta(idTarjeta);

		//Comprobamos que el pedido está en estado carrito y que la dirección y la tarjeta son del usuario
		//Si el usuario que recuperamos es el mismo que tenemos en sesión, y tiene el pedido en estado carrito,
		// al hacer la compra cambiamos el estado del pedido a completado y guardamos el pedido.
		if(pedido.getEstado().equals("CARRITO")) {
			pedido.setEstado("COMPLETADO");
			pedido.setDireccione(dir);
			pedido.setTarjeta(tar);
			pRepo.save(pedido);
			proService.reducirStock(pedido);
			
			misesion.removeAttribute("carrito");
		}else {
			model.addAttribute("error", "No se ha podido realizar el pago");
			return "redirect:/procesarCompra";
		}
		return "paginaCompra";
	}

}
