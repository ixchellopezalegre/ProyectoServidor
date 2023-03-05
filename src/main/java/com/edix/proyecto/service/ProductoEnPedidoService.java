package com.edix.proyecto.service;

import java.util.List;
import java.util.Map;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.beans.ProductosEnPedido;

public interface ProductoEnPedidoService {

	ProductosEnPedido buscarPorPedido(int numeroOrden);

	List<ProductosEnPedido> buscarTodosPorPedido(int numeroOrden);

//	Map<Producto, Integer> recuperarProductosPorPedido(Integer idPedido);
}
