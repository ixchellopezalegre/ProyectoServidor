package com.edix.proyecto.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.beans.Usuario;

public interface CarritoService {

	void sumarProductoEnCarrito(Map<Producto,Integer> carrito, Integer idProducto);
	void restarProductoEnCarrito(Map<Producto,Integer> carrito, Integer idProducto);
	void guardarCarrito(Map<Producto,Integer> carrito, Usuario usuario);
	Map<Producto,Integer> recuperarCarrito(Integer idUsuario);

}
