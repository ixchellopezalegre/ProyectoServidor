package com.edix.proyecto.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.proyecto.beans.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	
	@Query("Select p FROM Pedido p where p.usuario.idUsuario =?1")
	public Pedido buscarPedidoPorCliente(int idUsuario);
	
}
