package com.edix.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository urepo;
	
	@Override
	public List<Usuario> buscarTodos() {
		
		return urepo.findAll();
	}
	
	@Override
	public Usuario buscarUno(int idUsuario) {
		return urepo.findById(idUsuario).orElse(null);
	}

	
}
