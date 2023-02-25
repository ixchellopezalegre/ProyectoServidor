package com.edix.proyecto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edix.proyecto.beans.Pedido;
import com.edix.proyecto.service.PedidoServiceImpl;
import com.edix.proyecto.service.ProductoEnPedidoImpl;

@Controller
public class PedidoController {

	@Autowired PedidoServiceImpl pSer;
	
	@Autowired ProductoEnPedidoImpl pep;
	
	
	@GetMapping("/pedido")
	public String mostrarListaPedidos(Model model) {
		
		model.addAttribute("listaPedido", pSer.buscarTodos());
		return "listaPedidos";
	}
	
	@GetMapping("/buscarUno")
	public String mostrarFormularioBusqueda() {
		return "verPedido";
	}
	
	@PostMapping("/buscarUnPedido")
	public String buscarPedidoPorCliente(Model model, @RequestParam("idUsuario") int idUsuario) {
		
		Pedido pedido = pSer.buscarPorCliente(idUsuario);
		if(pedido != null) {
			model.addAttribute("pedido",pedido);
			model.addAttribute("mensaje","Este cliente tiene pedidos");
			System.out.println(pedido);
		}else
			model.addAttribute("mensaje", "Cliente sin pedidos");
		return "verPedido";
	}
	
	@GetMapping("/detallePedido/{id}")
	public String productosEnPedidos(Model model,@PathVariable("id") int idPedido) {
		
		model.addAttribute("p", pep.buscarPorPedido(idPedido));
		
		return "detallePedido";
		
	}
	
	
	
}
