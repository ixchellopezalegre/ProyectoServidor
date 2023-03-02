package com.edix.proyecto.model.dto;

import java.util.List;

public interface UsuarioDTOService {
	List<UsuarioDTO> buscarPorProvincia(String provincia);
}
