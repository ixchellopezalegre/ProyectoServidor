package com.edix.proyecto.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.beans.Usuario;

@Service
public class CarritoServiceImpl implements CarritoService{

	@Autowired
	ProductoService prodServ;
	
	@Autowired
	PedidoService pedServ;
	

	/**
	 * Si el carrito ya contiene el producto y no supera las 10 uds, 
	 * añade una unidad al producto con el Id pasado por parámetro
	 * Si el carrito no lo contiene, añade una unidad
	 */
	@Override
	public void sumarProductoEnCarrito(Map<Producto, Integer> carrito, Integer idProducto) {
		Producto producto = prodServ.buscarUno(idProducto);
		
		if (carrito.containsKey(producto)) {
            int cantActual = carrito.get(producto);
            int cantAumentada = ++cantActual;
            if (cantAumentada <= 10) {
            	carrito.put(producto, cantAumentada);
            }
            
        } else {
        	carrito.put(producto, 1);
        }
		
	}

	@Override
	public void restarProductoEnCarrito(Map<Producto, Integer> carrito, Integer idProducto) {
	Producto producto = prodServ.buscarUno(idProducto);
		
		if (carrito.containsKey(producto)) {
            int cantActual = carrito.get(producto);
            cantActual--;
            if (cantActual == 0) {            	
            	carrito.remove(producto);
            }else {
            	carrito.put(producto, cantActual);
            }            
        } 		
	}

	@Override
	public void guardarCarrito(Map<Producto, Integer> carrito, Usuario usuario) {
		
		
	}
	
	
	
	
	
	
}
