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

	//Busqueda de todos los pedidos.
	@Override public List<Pedido> buscarTodos() {
		return pRepo.findAll();
	}

	//Busqueda de pedidos por idCliente.
	@Override
	public List<Pedido> buscarPorCliente(int idUsuario) {
		return pRepo.buscarPedidoPorCliente(idUsuario);
	}

	//Busqueda de pedidos por idPedido.
	@Override
	public Pedido buscarPorPedido(int idPedido) {
		return pRepo.findById(idPedido).orElse(null);
	}

	//Listado de pedidos pendientes.
	@Override
	public List<Pedido> buscarPendientes() {;
		return pRepo.buscarPendientes();
	}
	//Listado de pedidos completados
	@Override
	public List<Pedido> buscarCompletados() {
		return pRepo.buscarCompletados();
	}

	//Listado de pedidos que se han hecho en el día actual.
	@Override
	public List<Pedido> buscarHoy() {
		return pRepo.buscarHoy();
	}

	//Metodo para dar de lata un pedido.
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
