package com.edix.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.edix.proyecto.beans.Usuario;

public interface UsuarioService {
	List<Usuario> buscarTodos();
	boolean registrarUsuario(Usuario usuario);
	Usuario buscarUsuario(int idUsuario);

}
