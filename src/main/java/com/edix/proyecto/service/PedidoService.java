package com.edix.proyecto.service;

import java.util.List;
import com.edix.proyecto.beans.Pedido;
import com.edix.proyecto.beans.ProductosEnPedido;

public interface PedidoService {
	
	List<Pedido> buscarTodos();
	List<Pedido> buscarPorCliente(int idUsuario);
	Pedido buscarPorPedido(int idPedido);
	List<Pedido> buscarPendientes();
	List<Pedido> buscarCompletados();
	List<Pedido> buscarHoy();
	boolean hacerPedido(Pedido p);
}
