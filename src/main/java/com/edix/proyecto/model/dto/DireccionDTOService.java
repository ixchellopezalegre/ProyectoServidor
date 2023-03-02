package com.edix.proyecto.model.dto;

import java.util.List;

public interface DireccionDTOService {
	List<DireccionDTO> buscarTodas();
	int contarClientesPorLocalidad(String provincia);
}

