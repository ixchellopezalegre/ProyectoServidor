package com.edix.proyecto.service;

import com.edix.proyecto.beans.ProductosEnPedido;

public interface ProductoEnPedidoService {

	ProductosEnPedido buscarPorPedido(int numeroOrden);
}
