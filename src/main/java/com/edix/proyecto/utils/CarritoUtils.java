package com.edix.proyecto.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.edix.proyecto.beans.Producto;

@Component
public class CarritoUtils {
	
	/**
	 * Comprueba si en la sesión existe ya un atributo "carrito" 
	 * y si no existe lo crea y lo asigna a la sesion y al model
	 * Si existe lo recupera y lo asigna como atributo "carrito" al model
	 * 
	 * @param misesion
	 * @param model
	 * @return Un carrito (mapa de Producto y cantidad)
	 */
	public Map<Producto, Integer> comprobaroCrearCarrito(HttpSession misesion, Model model) {
			
			Map<Producto, Integer> carrito = null;
			if (misesion.getAttribute("carrito") == null) {		 
				 carrito = new HashMap<Producto, Integer>();
				misesion.setAttribute("carrito",carrito);
			}else {
				 carrito = (Map<Producto, Integer>) misesion.getAttribute("carrito");
			}
			
			model.addAttribute("carrito", carrito);
			
			return carrito;
		}
}
