package com.edix.proyecto.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.edix.proyecto.beans.Pedido;
import com.edix.proyecto.beans.ProductosEnPedido;
import com.edix.proyecto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.utils.CarritoUtils;


@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
	@Autowired 
	CarritoService caServ;

	@Autowired
	ProductoEnPedidoService pepServ;

	@Autowired
	UsuarioServiceImpl uServ;

	@Autowired
	DireccionServiceImpl dServ;

	@Autowired
	TarjetaServiceImpl tServ;

	@Autowired
	PedidoService pServ;

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
		caServ.sumarProductoEnCarrito(carrito, idProducto);
		
		return "redirect:/carrito";
	}
	
	/**
	 * Recupera el carrito en sesión y elimina una unidad del producto pasado por parámetro
	 * @return
	 */
	@GetMapping("/eliminarUno/{idProducto}")
	public String eliminarUno(Model model,@PathVariable int idProducto,HttpSession misesion) {
		
		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		caServ.restarProductoEnCarrito(carrito, idProducto);
		
		return "redirect:/carrito";
	}
	
	@GetMapping("/guardar")
	public String guardarCarrito(Model model, HttpSession misesion) {
		
		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		Usuario user = (Usuario) misesion.getAttribute("sesion");
		
		caServ.guardarCarrito(carrito, user);
		
		return "redirect:/carrito";
	}

	@GetMapping("/comprar")
	public String mostrarCompra(Model model, HttpSession misesion) {
		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		Usuario user = (Usuario) misesion.getAttribute("sesion");

		model.addAttribute("carrito", carrito);
		model.addAttribute("user", uServ.buscarUsuario(user.getIdUsuario()));

		return "procesarCompra";
	}

	@PostMapping("/pagar")
	public String pagarCarrito(@RequestParam int idDireccion,
							   @RequestParam int idTarjeta,
							   Pedido pedido, Model model, HttpSession misesion) {

		Usuario user = (Usuario) misesion.getAttribute("sesion");
		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		pedido.setFecha(new Date());
		pedido.setUsuario(user);
		pedido.setDireccione(dServ.buscarDireccion(idDireccion));
		pedido.setTarjeta(tServ.buscarTarjeta(idTarjeta));

		for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
			ProductosEnPedido pep = new ProductosEnPedido();
			pep.setCantidad(entry.getValue());
			pep.setProducto(entry.getKey());
			pep.setPedido(pedido);
			System.out.println(pep.getCantidad() + " " + pep.getProducto().getNombre() + " " + pep.getPedido().getIdPedido());
			pepServ.guardarProductosEnPedido(pep);
			if(pepServ.guardarProductosEnPedido(pep)) {
				System.out.println("Guardado");
			}else {
				System.out.println("No guardado");
			}
			pedido.addProductosEnPedido(pep);
		}
		pedido.setEstado("Completado");
		pServ.hacerPedido(pedido);

		return "paginaCompra";
	}
}
