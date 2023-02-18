package com.edix.proyecto.service;

import java.util.List;

import com.edix.proyecto.beans.Producto;

public interface ProductoService {

	List<Producto>buscarTodos();
	Producto buscarProducto(int idProducto);
	Producto buscarPorNombre(String nombre);
	boolean registrarProducto(Producto producto);
	boolean borrarProducto(int idProducto);
	boolean modificarProducto(Producto producto);
	
}
