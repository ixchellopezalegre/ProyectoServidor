package com.edix.proyecto.controller;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.CarritoService;
import com.edix.proyecto.service.RolService;
import com.edix.proyecto.service.UsuarioService;
import com.edix.proyecto.utils.CarritoUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired UsuarioService uRepo;
	@Autowired RolService rolSer;
	@Autowired CarritoService caService;
	@Autowired CarritoUtils caUtil;
	private	PasswordEncoder pwcript;

	// Inyectamos el componente PasswordEncoder
	public HomeController(PasswordEncoder pwcript) {
		this.pwcript = pwcript;
	}

	//Mapeo de la página principal
	@GetMapping("/")
	public String mostarHome() {
		return "index";
	}

	/**
	 * //Mapeo de la página de login
	 * @param Authentication aut
	 * @param model, con el que se le pasa el carrito al usuario
	 * @param misesion para asignarlo al usuario que está logueado
	 * @return
	 */
	@GetMapping("/inicio")
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {
		Usuario usuario = uRepo.buscarPorEmail(aut.getName());

		if (misesion.getAttribute("sesion") == null)
			misesion.setAttribute("sesion", usuario);

		System.out.println("Nombre : " + aut.getName());
		for (GrantedAuthority ele: aut.getAuthorities())
			System.out.println("Roles : " + ele.getAuthority());
		
		//Cargar carrito que tenemos en sesión
		caUtil.comprobaroCrearCarrito(misesion, model);
		Map<Producto, Integer> carrito = new HashMap<>();
		carrito = caService.recuperarCarrito(usuario.getIdUsuario());
		
		misesion.setAttribute("carrito",carrito);
		model.addAttribute("carrito", carrito);

		return "redirect:/";
	}
	
	@GetMapping("/registro")
	public String mostarRegistro() {
		return "registro";
	}

	/**
	 * Método para registrar un usuario nuevo.
	 * @param model
	 * @param Atributos del usuario para construir un nuevo objeto "usuario"
	 * @return	redirige a la página de login una vez se ha registrado el usuario
	 */
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
	   	// Encriptamos la contraseña
	    usuario.setPassword(pwcript.encode(password));

		//Comprobamos si el registro de usuario ha sido correcto
	    if(uRepo.registrarUsuario(usuario)) {
	    		usuario.setIdUsuario(usuario.getIdUsuario());
	        return "redirect:/login";
	    } else {
	        model.addAttribute("mensaje", "Ha ocurrido un error");
	        return "registro";
	    }
	}

	/**
	 * Método para encriptar una contraseña, mostrándola por el navegador.
	 */
	@GetMapping("/encriptar/{pass}")
	@ResponseBody
	public String encriptar(@PathVariable("pass") String pass) {
		String newPassw= null;
		newPassw = "El texto es: " + pwcript.encode(pass);
		return newPassw;
	}

	/**
	 * Método para cerrar sesión
	 * @param model
	 * @param misesion para que alamacene la sesión del carrito y no perderla cuando iniciemos de nuevo sesión
	 * @return nos redirige a la página de cerrar sesión
	 */
	@GetMapping("/user/logout")
	public String logout(Model model, HttpSession misesion) {
		Map<Producto, Integer> carrito = caUtil.comprobaroCrearCarrito(misesion, model);
		Usuario user = (Usuario) misesion.getAttribute("sesion");
		
		caService.guardarCarrito(carrito, user);
		misesion.removeAttribute("sesion");
		
		return "redirect:/logout";
		
	}
	

}
