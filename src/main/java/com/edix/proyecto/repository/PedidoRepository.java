package com.edix.proyecto.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.proyecto.beans.Pedido;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	@Query("Select p FROM Pedido p where p.usuario.idUsuario =?1")
	 List<Pedido> buscarPedidoPorCliente(int idUsuario);
	
	@Query("Select p FROM Pedido p where p.usuario.idUsuario =?1 and  p.estado = 'CARRITO'")
	 Pedido buscarPedidoCarritoPorCliente(int idUsuario);

	@Query("Select p FROM Pedido p where p.estado = 'CARRITO'")
	 List<Pedido> buscarPendientes();

	@Query("Select p FROM Pedido p where p.estado = 'COMPLETADO'")
	 List<Pedido> buscarCompletados();

	//Truncamos la fecha para que solo tenga en cuenta la fecha y no la hora.
	// Fuente: https://stackoverflow.com/questions/63362765/date-trunc-function-in-jpql-query
	@Query("SELECT p FROM Pedido p WHERE FUNCTION('DATE', p.fecha) = CURRENT_DATE")
	 List<Pedido> buscarHoy();

}
