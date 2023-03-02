package com.edix.proyecto.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.CarritoService;
import com.edix.proyecto.utils.CarritoUtils;


@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
	@Autowired 
	CarritoService caService;
	
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

	
	
	
	
}
