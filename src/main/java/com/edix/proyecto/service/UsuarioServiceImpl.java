package com.edix.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.edix.proyecto.beans.Direccion;
import com.edix.proyecto.beans.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository uRepo;

	@Autowired
	RolService rServ;

	@Autowired
	PedidoService pServ;
	private PasswordEncoder pwcript;

	public UsuarioServiceImpl(PasswordEncoder pwcript) {
		this.pwcript = pwcript;
	}

	@Override
	public List<Usuario> buscarTodos() {
		return uRepo.findAll();
	}

	@Override
	public Usuario buscarUsuario(int idUsuario) {
		return uRepo.findById(idUsuario).orElse(null);
	}

	public Usuario buscarPorEmail(String email) {
		return uRepo.findByEmail(email);
	}


	@Override
	public boolean registrarAdmin(Usuario usuario) {
		try {
			//Añadimos el rol de administrador
			usuario.addRol(rServ.buscarRol(2));
			//Encriptamos la contraseña
			usuario.setPassword(pwcript.encode(usuario.getPassword()));
			//Generamos un mail de administrador automáticamente
			usuario.setEmail(usuario.getNombre().toLowerCase() +"." +usuario.getApellidos().toLowerCase() + "@edix.com");

			uRepo.save(usuario);
			System.out.println("OK: Se ha registrado el usuario.");
			return true;
		} catch (Exception e) {
			System.out.println("Error: No se ha registrado el usuario.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean registrarUsuario(Usuario usuario) {
		try {
			usuario.addRol(rServ.buscarRol(1));
			//Encriptamos la contraseña
			uRepo.save(usuario);
			System.out.println("OK: Se ha registrado el usuario.");
			return true;
		} catch (Exception e) {
			System.out.println("Error: No se ha registrado el usuario.");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean actualizarUsuario(Usuario usuario) {
		Optional<Usuario> usuarioExistente = uRepo.findById(usuario.getIdUsuario());
		if (usuarioExistente.isPresent()) {
			uRepo.save(usuario);
			return true;
		}
		return false;
	}

	@Override
	public boolean anadirDireccion(Usuario usuario, Direccion direccion) {
		Optional<Usuario> usuarioExistente = uRepo.findById(usuario.getIdUsuario());
		if (usuarioExistente.isPresent()) {
			usuario.getDirecciones().add(direccion);
			uRepo.save(usuario);
			return true;
		}
		return false;
	}

	@Override
	public boolean anadirTarjeta(Usuario usuario, Tarjeta tarjeta) {
		Optional<Usuario> usuarioExistente = uRepo.findById(usuario.getIdUsuario());
		if (usuarioExistente.isPresent()) {
			usuario.getTarjetas().add(tarjeta);
			uRepo.save(usuario);
			return true;
		}
		return false;
	}

}
