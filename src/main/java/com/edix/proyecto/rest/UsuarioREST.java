package com.edix.proyecto.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import com.edix.proyecto.service.UsuarioServiceImpl;

@Controller
@RequestMapping("/user")
public class UsuarioREST {

	@Autowired UsuarioServiceImpl user;
	
	@GetMapping("/todos")
	public String buscarTodos(Model model){
		
		model.addAttribute("usuarios", user.buscarTodos());
		
		return "usuarios";
	}
	
	@GetMapping("/ver/{id}")
	public String buscarUno(Model model, @PathVariable int id){
			
			model.addAttribute("usuario", user.buscarUno(id));
			
			return "verUno";
	}
}
