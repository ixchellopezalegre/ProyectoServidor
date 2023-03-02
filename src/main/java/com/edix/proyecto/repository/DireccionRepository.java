package com.edix.proyecto.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.proyecto.beans.Direccion;


public interface DireccionRepository extends JpaRepository<Direccion, Integer>{
	
	@Query(value = "SELECT d.localidad, ucd.id_usuario " +
	        "FROM direcciones d " +
	        "JOIN usuarios_con_direcciones ucd ON d.id_direccion = ucd.id_direccion " +
	        "WHERE d.localidad = ?1", nativeQuery = true)
	List<Direccion> buscarPorLocalidad(String localidad);




}
