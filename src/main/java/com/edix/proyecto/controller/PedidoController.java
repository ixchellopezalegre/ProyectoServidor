package com.edix.proyecto.controller;



import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edix.proyecto.beans.Pedido;
import com.edix.proyecto.service.PedidoServiceImpl;
import com.edix.proyecto.service.ProductoEnPedidoImpl;


import java.util.List;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoServiceImpl pSer;

	@Autowired
	UsuarioServiceImpl uSer;

	@Autowired
	ProductoEnPedidoImpl pep;


	@GetMapping("/todos")
	public String mostrarListaPedidos(Model model) {
		model.addAttribute("pedidosDe", "Todos los pedidos");
		model.addAttribute("listaPedidos", pSer.buscarTodos());
		return "listaPedidos";
	}

	@GetMapping("/buscar")
	public String buscar(@RequestParam("idUsuario") int idUsuario) {
		return "forward:/pedido/" + idUsuario;
	}

	@GetMapping("/{idUsuario}")
	public String buscarPedidosPorCliente(Model model, @PathVariable int idUsuario) {
		
		List<Pedido> listaPedidos = pSer.buscarPorCliente(idUsuario);
		Usuario user = uSer.buscarUsuario(idUsuario);
		
		model.addAttribute("pedidosDe","Pedidos del usuario " + user.getNombre());
		model.addAttribute("listaPedidos",listaPedidos);
		
		if(listaPedidos.size() != 0) {
			System.out.println("Este cliente tiene pedidos");
		}else
			model.addAttribute("mensaje", user.getNombre() + " no tiene pedidos");
			System.out.println("Este cliente NO tiene pedidos");
		return "listaPedidos";
	}
	
	@GetMapping("/detallePedido/{id}")
	public String productosEnPedidos(Model model,@PathVariable int idPedido) {
		
		model.addAttribute("p", pep.buscarPorPedido(idPedido));
		return "detallePedido";
	}

	@GetMapping("/pendientes")
	public String pedidosPendientes(Model model) {
		model.addAttribute("pedidosDe", "Todos los pedidos pendientes");
		model.addAttribute("listaPedidos", pSer.buscarPendientes());
		return "listaPedidos";
	}

	@GetMapping("/completados")
	public String pedidosCompletados(Model model) {
		model.addAttribute("pedidosDe", "Todos los pedidos completados");
		model.addAttribute("listaPedidos", pSer.buscarCompletados());
		return "listaPedidos";
	}

	@GetMapping("/hoy")
	public String pedidosHoy(Model model) {
		model.addAttribute("pedidosDe", "Todos los pedidos de hoy");
		model.addAttribute("listaPedidos", pSer.buscarHoy());
		return "listaPedidos";
	}

}
