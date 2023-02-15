package com.edix.proyecto.rest;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.UsuarioServiceImpl;

@Controller
@RequestMapping("/user")
public class UsuarioREST {

	@Autowired UsuarioServiceImpl user;
	
	@GetMapping("/todos")
	public String buscarTodos(Model model){
		
		model.addAttribute("usuario", user.buscarTodos());
		return "usuarios";	
	}
	
	@GetMapping("/buscarUno/{id}")
	public String buscarUsuario(Model model,@PathVariable("id") int idUsuario) {
		
			Usuario usuario = user.buscarUsuario(idUsuario);
			model.addAttribute("user", usuario);
		return "";
	}
	
	@GetMapping("/registro")
	public String mostarRegistro() {
		return "registro";
	}
}
