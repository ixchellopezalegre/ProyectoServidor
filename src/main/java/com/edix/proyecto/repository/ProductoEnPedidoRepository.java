package com.edix.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.proyecto.beans.ProductosEnPedido;

public interface ProductoEnPedidoRepository extends JpaRepository<ProductosEnPedido, Integer> {
	
	@Query("SELECT p FROM ProductosEnPedido p WHERE p.numeroOrden=?1")
	ProductosEnPedido buscarUno(int numeroOrden);

}
