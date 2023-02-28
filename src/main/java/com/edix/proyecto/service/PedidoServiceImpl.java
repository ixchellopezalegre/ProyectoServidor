package com.edix.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.proyecto.beans.Pedido;
import com.edix.proyecto.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	
	@Autowired PedidoRepository pRepo;
	
	@Override
	public List<Pedido> buscarTodos() {
		return pRepo.findAll();
	}

	@Override
	public Pedido buscarPorCliente(int idUsuario) {
		return pRepo.buscarPedidoPorCliente(idUsuario);
	}

	@Override
	public Pedido buscarPorPedido(int idPedido) {
		return pRepo.findById(idPedido).orElse(null);
	}

}
