package com.edix.proyecto.service;

import java.util.List;

import com.edix.proyecto.beans.ProductosEnPedido;
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
	public List<Pedido> buscarPorCliente(int idUsuario) {
		return pRepo.buscarPedidoPorCliente(idUsuario);
	}

	@Override
	public Pedido buscarPorPedido(int idPedido) {
		return pRepo.findById(idPedido).orElse(null);
	}

	@Override
	public List<Pedido> buscarPendientes() {;
		return pRepo.buscarPendientes();
	}

	@Override
	public List<Pedido> buscarCompletados() {
		return pRepo.buscarCompletados();
	}

	@Override
	public List<Pedido> buscarHoy() {
		return pRepo.buscarHoy();
	}


	@Override
	public boolean hacerPedido(Pedido p) {
		try {
			pRepo.save(p);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
