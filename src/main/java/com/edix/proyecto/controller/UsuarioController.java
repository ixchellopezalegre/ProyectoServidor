package com.edix.proyecto.controller;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.RolServiceImpl;
import com.edix.proyecto.service.UsuarioServiceImpl;

@Controller
@RequestMapping("/user")
public class UsuarioController {

	@Autowired UsuarioServiceImpl uServ;
	
	@Autowired RolServiceImpl rolServ;

	
	@GetMapping("/todos")
	public String buscarTodos(Model model){

		model.addAttribute("usuario", uServ.buscarTodos());
		return "listaUsuarios";	
	}
	
	@GetMapping("/gestion")
	public String gentionAdministrador() {
		return "gestionAdmin";
	}
	
	@PostMapping("/gestion")
	public String registrarUsuario(Model model, @RequestParam("nombre") String nombre ,
												@RequestParam("apellidos")String apellidos,
												@RequestParam("email")String email, 
												@RequestParam("fechaNacimiento") Date fechaNacimiento, 
												@RequestParam("password") String password ){
	    
	    Usuario usuario = new Usuario();
	    usuario.setNombre(nombre);
	    usuario.setApellidos(apellidos);
	    usuario.setEmail(email);
	    usuario.setFechaNacimiento(new Timestamp(fechaNacimiento.getTime())); /*Convertir fecha a TIMESTAMP*/
	    usuario.setPassword(password);
	    
	    /*Asignamos, que por defecto se le asigne el rol de cliente a los nuevos usuarios registrados*/
    	usuario.addRol(rolServ.buscarRol(2));
	   
	    if(uServ.registrarUsuario(usuario)) {
	    		usuario.setIdUsuario(usuario.getIdUsuario());
	        return "redirect:/";
	    } else {
	        model.addAttribute("mensaje", "No hemos podido gestionar el alta");
	        return "registro";
	    }
	}
	
	@GetMapping("/datos")
	public String datosUsuario(Model model, Authentication auth) {

		model.addAttribute("usuario", uServ.buscarPorEmail(auth.getName()));
		return "datosUsuario";
	}
	
}
