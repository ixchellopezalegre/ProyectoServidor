package com.edix.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.proyecto.beans.ProductosEnPedido;
import com.edix.proyecto.repository.ProductoEnPedidoRepository;

@Service
public class ProductoEnPedidoImpl implements ProductoEnPedidoService{

	@Autowired ProductoEnPedidoRepository pRep;

	//Buscar los por el idPedido
	@Override
	public ProductosEnPedido buscarPorPedido(int numeroOrden) {
		return pRep.buscarUno(numeroOrden);
	}

	//Listado de los productos que tenemos dentro de un pedido.
	@Override
	public List<ProductosEnPedido> buscarTodosPorPedido(int idPedido) {
		return pRep.buscarTodosPorIdPedido(idPedido);
	}
}
