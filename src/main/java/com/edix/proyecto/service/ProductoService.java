package com.edix.proyecto.service;

import java.util.List;

import com.edix.proyecto.beans.Pedido;
import com.edix.proyecto.beans.Producto;

public interface ProductoService {

	List<Producto>buscarTodos();
	Producto buscarUno(int idProducto);
	Producto buscarPorNombre(String nombre);
	List<Producto> buscarPorNombreODescripcion(String nombre);
	boolean registrarProducto(Producto producto);
	boolean borrarProducto(int idProducto);
	boolean modificarProducto(Producto producto);
	List<Producto> ordenarAlfabeticamenteAsc();

	List<Producto> ordenarAlfabeticamenteDesc();
	List<Producto> ordenarPorPrecioAsc();

	List<Producto> ordenarPorPrecioDesc();
	
	boolean reducirStock(Pedido pedido);

}
