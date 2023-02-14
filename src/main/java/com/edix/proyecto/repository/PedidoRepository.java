package com.edix.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.proyecto.beans.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
