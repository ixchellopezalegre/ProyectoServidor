package com.edix.proyecto.model.dto;

import java.util.List;

import com.edix.proyecto.beans.Direccion;



public interface DireccionDTOService {
	List<DireccionDTO> buscarTodas();
	List<Direccion> buscarPorProvincia(String localidad);
	
}
