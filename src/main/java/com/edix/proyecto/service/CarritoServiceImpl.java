package com.edix.proyecto.service;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.proyecto.beans.Pedido;
import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.beans.ProductosEnPedido;
import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.repository.PedidoRepository;
import com.edix.proyecto.repository.ProductoEnPedidoRepository;

@Service
public class CarritoServiceImpl implements CarritoService {

	@Autowired
	ProductoService prodServ;

	@Autowired
	PedidoService pedServ;

	@Autowired
	ProductoEnPedidoRepository pepRepo;

	@Autowired
	PedidoRepository pedRepo;


	/**
	 * Si el carrito ya contiene el producto y no supera las 10 uds,
	 * añade una unidad al producto con el Id pasado por parámetro
	 * Si el carrito no lo contiene, añade una unidad
	 */
	@Override
	public void sumarProductoEnCarrito(Map<Producto, Integer> carrito, Integer idProducto) {
		Producto producto = prodServ.buscarUno(idProducto);

		if (carrito.containsKey(producto)) {
			int cantActual = carrito.get(producto);
			int cantAumentada = ++cantActual;
			if (cantAumentada <= 10) {
				carrito.put(producto, cantAumentada);
			}

		} else {
			carrito.put(producto, 1);
		}

	}

	@Override
	public void restarProductoEnCarrito(Map<Producto, Integer> carrito, Integer idProducto) {
		Producto producto = prodServ.buscarUno(idProducto);

		if (carrito.containsKey(producto)) {
			int cantActual = carrito.get(producto);
			cantActual--;
			if (cantActual == 0) {
				carrito.remove(producto);
			} else {
				carrito.put(producto, cantActual);
			}
		}
	}

	@Override
	public void guardarCarrito(Map<Producto, Integer> carrito, Usuario usuario) {
		if (carrito != null) {
			Pedido pedido = pedRepo.buscarPedidoCarritoPorCliente(usuario.getIdUsuario());


			if (pedido == null) pedido = new Pedido();

			Date fechaActual = new Date();
			String estadoCarrito = "CARRITO";

			//Guardamos en el objeto pedido los datos que necesitamos

			//FECHA
			pedido.setFecha(fechaActual);

			//ID_USUARIO
			pedido.setUsuario(usuario);

			//ESTADO
			pedido.setEstado(estadoCarrito);

			List<ProductosEnPedido> productos = pedido.getProductosEnPedidos();

			if (productos != null && !productos.isEmpty())
				pepRepo.deleteAllInBatch(productos);

			
			//Guardamos el pedido en BBDD y guardamos el objeto Pedido que devuelve
			Pedido pedidoGuardado = pedRepo.save(pedido);

			//Guardamos en el objeto productosEnPedido los datos que necesitamos
			for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {

				ProductosEnPedido productosEnPedido = new ProductosEnPedido();
				BigDecimal cantidad = new BigDecimal(entry.getValue());
				BigDecimal precio = entry.getKey().getPrecio();
				BigDecimal precioTotal = cantidad.multiply(precio);

				productosEnPedido.setPedido(pedidoGuardado);
				productosEnPedido.setProducto(entry.getKey());
				productosEnPedido.setCantidad((int) entry.getValue());
				productosEnPedido.setPrecioTotal(precioTotal);

				pepRepo.save(productosEnPedido);
			}

		}
	}

	@Override
	public Map<Producto, Integer> recuperarCarrito(Integer idUsuario) {
		Map<Producto, Integer> carrito = new HashMap<>();
		List<ProductosEnPedido> productosEnPedidoLista = pepRepo.ProductosEnPedidoPorUsuario(idUsuario);

		for (ProductosEnPedido pep : productosEnPedidoLista) {
			Producto producto = pep.getProducto();
			Integer cantidad = pep.getCantidad();

			carrito.put(producto, cantidad);
		}

		return carrito;

	}

	@Override
	public void eliminarCarrito(int idUsuario) {
		Pedido pedido = pedRepo.buscarPedidoCarritoPorCliente(idUsuario);
		if (pedido != null) {
			List<ProductosEnPedido> productos = pedido.getProductosEnPedidos();
			if (productos != null && !productos.isEmpty()) {
				pepRepo.deleteAll(productos);
				pedRepo.delete(pedido);
			} else {
				System.out.println("No hay carrito que eliminar");
			}
		}
	}
}



