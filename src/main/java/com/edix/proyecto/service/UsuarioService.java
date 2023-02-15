package com.edix.proyecto.service;

import java.util.List;

import com.edix.proyecto.beans.Usuario;

public interface UsuarioService {
	
	List<Usuario> buscarTodos();
	Usuario buscarUno(int idUsuario);
}
