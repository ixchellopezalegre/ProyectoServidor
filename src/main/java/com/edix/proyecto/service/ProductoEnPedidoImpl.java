package com.edix.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.proyecto.beans.ProductosEnPedido;
import com.edix.proyecto.repository.ProductoEnPedidoRepository;

@Service
public class ProductoEnPedidoImpl implements ProductoEnPedidoService{
	
	
	@Autowired 
	ProductoEnPedidoRepository pep;

	@Override
	public ProductosEnPedido buscarPorPedido(int numeroOrden) {
		return pep.buscarUno(numeroOrden);
	}

}
