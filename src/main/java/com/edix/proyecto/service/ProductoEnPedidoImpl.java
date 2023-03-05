package com.edix.proyecto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.beans.ProductosEnPedido;
import com.edix.proyecto.repository.ProductoEnPedidoRepository;

@Service
public class ProductoEnPedidoImpl implements ProductoEnPedidoService{

	@Autowired 
	ProductoEnPedidoRepository pRep;

	@Override
	public ProductosEnPedido buscarPorPedido(int numeroOrden) {
		return pRep.buscarUno(numeroOrden);
	}
	
	@Override
	public List<ProductosEnPedido> buscarTodosPorPedido(int idPedido) {
		return pep.buscarTodosPorIdPedido(idPedido);
	}
	
//	@Override
//	public Map<Producto, Integer> recuperarProductosPorPedido(Integer idUsuario) {
//		Map<Producto, Integer> carrito = new HashMap<>();
//		List<ProductosEnPedido> productosEnPedidoLista = pep.;
//
//		for (ProductosEnPedido pep : productosEnPedidoLista) {
//			Producto producto = pep.getProducto();
//			Integer cantidad = pep.getCantidad();
//
//			carrito.put(producto, cantidad);
//		}
//
//		return carrito;
//
//	}



}
