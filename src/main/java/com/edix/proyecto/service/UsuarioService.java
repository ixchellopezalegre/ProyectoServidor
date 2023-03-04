package com.edix.proyecto.service;

import java.util.List;
import com.edix.proyecto.beans.Direccion;
import com.edix.proyecto.beans.Tarjeta;
import com.edix.proyecto.beans.Usuario;

public interface UsuarioService {

	List<Usuario> buscarTodos();
	Usuario buscarUsuario(int idUsuario);
	Usuario buscarPorEmail(String email);
	boolean registrarUsuario(Usuario usuario);
	boolean actualizarUsuario(Usuario usuario);
	boolean anadirDireccion(Usuario usuario, Direccion direccion);
    boolean anadirTarjeta(Usuario usuario, Tarjeta tarjeta);
}
