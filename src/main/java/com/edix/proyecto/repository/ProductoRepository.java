package com.edix.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.proyecto.beans.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
