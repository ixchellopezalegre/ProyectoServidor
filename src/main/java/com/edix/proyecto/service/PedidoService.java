package com.edix.proyecto.service;

import java.util.List;
import com.edix.proyecto.beans.Pedido;

public interface PedidoService {
	
	List<Pedido> buscarTodos();
	Pedido buscarPorCliente(int idUsuario);
	Pedido buscarPorPedido(int idPedido);
	

}
