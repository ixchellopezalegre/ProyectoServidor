package com.edix.proyecto.model.dto;

import java.util.List;

import com.edix.proyecto.beans.Usuario;

public interface UsuarioDTOService {
	List<UsuarioDTO> buscarTodos();
	List<Object[]> buscarPorProvincia(String localidad);
}
