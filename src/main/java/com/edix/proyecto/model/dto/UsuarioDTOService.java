package com.edix.proyecto.model.dto;

import java.util.List;

public interface UsuarioDTOService {
	List<UsuarioDTO> buscarTodos();
	List<Object[]> buscarPorProvincia(String localidad);
}
