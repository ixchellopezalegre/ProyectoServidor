package com.edix.proyecto.service;

import java.util.Date;
import java.util.List;
import com.edix.proyecto.beans.Pedido;

public interface PedidoService {
	
	List<Pedido> buscarTodos();
	List<Pedido> buscarPorCliente(int idUsuario);
	Pedido buscarPorPedido(int idPedido);
	

	List<Pedido> buscarPendientes();

	List<Pedido> buscarCompletados();

	List<Pedido> buscarHoy();
}
