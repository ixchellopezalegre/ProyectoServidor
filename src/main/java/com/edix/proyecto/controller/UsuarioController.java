package com.edix.proyecto.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.edix.proyecto.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.RolServiceImpl;
import com.edix.proyecto.service.UsuarioServiceImpl;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UsuarioController {

	@Autowired UsuarioServiceImpl uServ;
	@Autowired PedidoService pServ;
	@Autowired RolServiceImpl rolServ;

	//Listado de todos los usuarios de nuestra base de datos.
	@GetMapping("/todos")
	public String buscarTodos(Model model){
		model.addAttribute("usuario", uServ.buscarTodos());
		return "listaUsuarios";
	}

	@GetMapping("/gestion")
	public String gentionAdministrador() {
		return "gestionAdmin";
	}

	/**
	 * Método que registra un usuario con rol de administrador.
	 * @param ratt
	 * @param Objeto usuario que se va a registrar.
	 * @return listado de todos los usuarios registrados JSP.
	 */
	@PostMapping("/gestion")
	public String resgistrarAdmin(RedirectAttributes ratt, Usuario usuario) {
		if(uServ.registrarAdmin(usuario)) {
			ratt.addFlashAttribute("mensaje", "Se ha registrado el usuario.");
		}else {
			ratt.addFlashAttribute("mensaje", "Error: No se ha registrado el usuario.");
		}
		return "redirect:/user/todos";
	}

	@GetMapping("/datos")
	public String datosUsuario(Model model, Authentication auth) {
		model.addAttribute("usuario", uServ.buscarPorEmail(auth.getName()));
		return "datosUsuario";
	}

	@GetMapping("/misPedidos")
	public String mostrarPedidos(Model model, Authentication auth) {
		Usuario usuario = uServ.buscarPorEmail(auth.getName());

		model.addAttribute("listaPedidos", pServ.buscarPorCliente(usuario.getIdUsuario()) );
		return "misPedidos";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
