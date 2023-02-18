package com.edix.proyecto.rest;

import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	UsuarioServiceImpl uRepo;
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

}
