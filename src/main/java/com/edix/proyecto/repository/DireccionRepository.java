package com.edix.proyecto.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.proyecto.beans.Direccion;


public interface DireccionRepository extends JpaRepository<Direccion, Integer>{
	
	@Query("SELECT u FROM Usuario u JOIN u.direcciones d WHERE d.localidad = ?1")
	List<Direccion> buscarPorLocalidad(String localidad);




}
