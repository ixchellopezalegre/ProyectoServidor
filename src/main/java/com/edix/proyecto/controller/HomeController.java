package com.edix.proyecto.controller;

import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.RolServiceImpl;
import com.edix.proyecto.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired UsuarioServiceImpl uRepo;
	
	@Autowired RolServiceImpl rolSer;
	
	@GetMapping("/")
	public String mostarHome() {
		return "index";
	}
	
	@GetMapping("/inicio")
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {
		Usuario usuario = uRepo.buscarPorEmail(aut.getName());

		if (misesion.getAttribute("sesion") == null)
			misesion.setAttribute("sesion", usuario);

		System.out.println("Nombre : " + aut.getName());
		for (GrantedAuthority ele: aut.getAuthorities())
			System.out.println("Roles : " + ele.getAuthority());

		return "redirect:/";
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
	    usuario.setFechaNacimiento(new Timestamp(fechaNacimiento.getTime())); /*Convertir fecha a TIMESTAMP*/
	    usuario.setPassword(password);
	    
	    /*Asignamos, que por defecto se le asigne el rol de cliente a los nuevos usuarios registrados*/
    	usuario.addRol(rolSer.buscarRol(1));
	   
	    if(uRepo.registrarUsuario(usuario)) {
	    	
	    		usuario.setIdUsuario(usuario.getIdUsuario());
	        return "redirect:/login";
	    } else {
	        model.addAttribute("mensaje", "Ha ocurrido un error");
	        return "registro";
	    }
	}

}
