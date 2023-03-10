package com.edix.proyecto.controller;



import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edix.proyecto.beans.Pedido;
import com.edix.proyecto.beans.ProductosEnPedido;

import java.util.List;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired PedidoService pSer;
	@Autowired UsuarioService uSer;
	@Autowired ProductoEnPedidoService pep;

	/**
	 * Muestra todos los pedidos
	 * @param model
	 * @return lista de pedidos completa JSP.
	 */
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

	/**
	 * Busqueda de pedidos dependiendo del id de usuario busquemos.
	 * @param model
	 * @param idUsuario id del usuario que queremos buscar.
	 * @return JSP con el pedido encontrado del usuario seleccionado.
	 */
	@GetMapping("/{idUsuario}")
	public String buscarPedidosPorCliente(Model model, @PathVariable int idUsuario) {
		List<Pedido> listaPedidos = pSer.buscarPorCliente(idUsuario);
		Usuario user = uSer.buscarUsuario(idUsuario);
		model.addAttribute("usuario", user);
		if(user == null) {
			model.addAttribute("pedidosDe", "No existe el usuario con id " + idUsuario);
			return "listaPedidos";
		}
		model.addAttribute("pedidosDe","Pedidos del usuario " + user.getNombre());
		model.addAttribute("listaPedidos",listaPedidos);
		
		if(listaPedidos.size() != 0) {
			System.out.println("Este cliente tiene pedidos");
		}else {
			model.addAttribute("pedidosDe", user.getNombre() + " no tiene pedidos");
			System.out.println("Este cliente NO tiene pedidos");
		}
		return "listaPedidos";
	}
	
	@GetMapping("/detallePedido/{idPedido}")
	public String productosEnPedidos(Model model,@PathVariable int idPedido) {
		List<ProductosEnPedido> listaProductos =  pep.buscarTodosPorPedido(idPedido);
		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("pedido", pSer.buscarPorPedido(idPedido));
		return "detallePedido";
	}


	/**
	 * Muestra los pedidos pendientes que tenemos en la base de datos.
	 * @param model
	 * @return Lista de pedidos general JSP
	 */
	@GetMapping("/pendientes")
	public String pedidosPendientes(Model model) {
		model.addAttribute("pedidosDe", "Todos los pedidos pendientes");
		model.addAttribute("listaPedidos", pSer.buscarPendientes());
		return "listaPedidos";
	}

	/**
	 * Muestra los pedidos completados que tenemos en la base de datos.
	 * @param model
	 * @return lista de pedidos general JSP
	 */
	@GetMapping("/completados")
	public String pedidosCompletados(Model model) {
		model.addAttribute("pedidosDe", "Todos los pedidos completados");
		model.addAttribute("listaPedidos", pSer.buscarCompletados());
		return "listaPedidos";
	}

	/**
	 * Muestra los pedidos de hoy que tenemos en la base de datos.
	 * @param model
	 * @return lista de pedidos general JSP
	 */
	@GetMapping("/hoy")
	public String pedidosHoy(Model model) {
		model.addAttribute("pedidosDe", "Todos los pedidos de hoy");
		model.addAttribute("listaPedidos", pSer.buscarHoy());
		return "listaPedidos";
	}
}
