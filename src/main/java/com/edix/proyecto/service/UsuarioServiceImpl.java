package com.edix.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.edix.proyecto.beans.Direccion;
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
	public Usuario buscarUsuario(int idUsuario) {
			return urepo.findById(idUsuario).orElse(null);
	}

	public Usuario buscarPorEmail(String email) {
		return urepo.findByEmail(email);
	}
	@Override
	public boolean registrarUsuario(Usuario usuario) {
		
	    Optional<Usuario> usuarioExistente = urepo.findById(usuario.getIdUsuario());
	    
	    if (!usuarioExistente.isPresent()) {
	        urepo.save(usuario);
	        return true;
	    }
	    return false;
	}

	@Override
	public boolean actualizarUsuario(Usuario usuario) {
		Optional<Usuario> usuarioExistente = urepo.findById(usuario.getIdUsuario());
		if (usuarioExistente.isPresent()) {
			urepo.save(usuario);
			return true;
		}
		return false;
	}

	@Override
	public boolean anadirDireccion(Usuario usuario, Direccion direccion) {
		Optional<Usuario> usuarioExistente = urepo.findById(usuario.getIdUsuario());
		if (usuarioExistente.isPresent()) {
			usuario.getDirecciones().add(direccion);
			urepo.save(usuario);
			return true;
		}
		return false;
	}

}
