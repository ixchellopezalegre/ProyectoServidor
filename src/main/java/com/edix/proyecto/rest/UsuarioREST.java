package com.edix.proyecto.rest;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.UsuarioServiceImpl;

@Controller
@RequestMapping("/user")
public class UsuarioREST {

	@Autowired UsuarioServiceImpl user;
	
	@GetMapping("/todos")
	public String buscarTodos(Model model){
		
		model.addAttribute("usuario", user.buscarTodos());
		return "listaUsuarios";	
	}
	
	@GetMapping("/registro")
	public String mostarRegistro() {
		return "registro";
	}
	
	@PostMapping("/registro")
	public String registrarUsuario(Model model, @RequestParam("nombre") String nombre ,
												@RequestParam("apellidos")String apellidos,
												@RequestParam("email")String email, 
												@RequestParam("fechaNacimiento") Date fechaNacimiento, 
												@RequestParam("password") String password ){
	    
	    Usuario usuario = new Usuario();
	    usuario.setNombre(nombre);
	    usuario.setApellidos(apellidos);
	    usuario.setEmail(email);
	    usuario.setFechaNacimiento(new Timestamp(fechaNacimiento.getTime())); // conversión a Timestamp
	    usuario.setPassword(password);
	    
	    if(user.registrarUsuario(usuario)) {
	    	usuario.setIdUsuario(usuario.getIdUsuario());
	        model.addAttribute("mensaje", "Usuario dado de alta");
	        return "redirect:/login";
	    } else {
	        model.addAttribute("mensaje", "Ha ocurrido un error");
	        System.out.println(usuario.getIdUsuario());
	        return "registro";
	    }
	}





}
