package com.edix.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.edix.proyecto.beans.Pedido;
import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.beans.ProductosEnPedido;
import com.edix.proyecto.repository.ProductoEnPedidoRepository;
import com.edix.proyecto.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired ProductoRepository pRepo;
	@Autowired ProductoEnPedidoRepository pepRepo;

	//Busqueda de todos los productos que hay en la base de datos
	@Override
	public List<Producto> buscarTodos() {
		return pRepo.findAll();
	}

	//Busqueda de los productos que coincidan con el id del producto.
	@Override
	public Producto buscarUno(int idProducto) {
		return pRepo.findById(idProducto).orElse(null);
	}

	//Busqueda de los productos que coincidan con el nombre del producto.
	@Override
	public Producto buscarPorNombre(String nombre) {
		return pRepo.findByNombre(nombre);
	}

	//Listado de los productos que coincidan con el nombre o la descripcion del producto.
	@Override
	public List<Producto> buscarPorNombreODescripcion(String nombre) {
		return pRepo.findByNombreOrDescripcionContainsIgnoreCase(nombre);
	}

	//Método para dar de alta un nuevo producto.
	@Override
	public boolean registrarProducto(Producto producto) {
		Optional<Producto> productoExistente = pRepo.findById(producto.getIdProducto());

		if (productoExistente.isEmpty()) {
			pRepo.save(producto);
			return true;
		}
		return false;
	}

	//Método para dar de baja un producto.
	@Override
	public boolean borrarProducto(int idProducto) {
		try {
			pRepo.deleteById(idProducto);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	//Método para modificar un producto.
	@Override
	public boolean modificarProducto(Producto producto){
		boolean resultado = false;
		Producto p1 = buscarUno(producto.getIdProducto());
		try{
			
			p1.setNombre(producto.getNombre());
			p1.setPrecio(producto.getPrecio());
			p1.setStock(producto.getStock());
			p1.setDescripcion(producto.getDescripcion());
			pRepo.save(p1);
			resultado = true;
		}catch(Exception e){
			System.out.println("No se ha actualizado el producto");
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public List<Producto> ordenarAlfabeticamenteAsc() {
		return pRepo.findAllByOrderByNombreAsc();
	}

	@Override
	public List<Producto> ordenarAlfabeticamenteDesc() {
		return pRepo.findAllByOrderByNombreDesc();
	}

	@Override
	public List<Producto> ordenarPorPrecioAsc() {
		return pRepo.findAllByOrderByPrecioAsc();
	}

	@Override
	public List<Producto> ordenarPorPrecioDesc() {
		return pRepo.findAllByOrderByPrecioDesc();
	}

	/**
	 * Reduce el stock de los productos del pedido, según las cantidades de Productos en Pedido
	 * del pedido que se pasa por parámetro
	 * @returns true si ha ido bien, false si no ha ido bien
	 */
	@Override
	public boolean reducirStock(Pedido pedido) {
		List<ProductosEnPedido> listaPep = pepRepo.buscarTodosPorIdPedido(pedido.getIdPedido());
		
		for (ProductosEnPedido pep : listaPep) {
			Producto producto = pep.getProducto();
			int cantidad = pep.getCantidad();
			
			int stock = pRepo.verStock(pep.getProducto().getIdProducto());
			if (stock > 0) { 
				producto.setStock(stock - cantidad);
				pRepo.save(producto);
			}else
				return false;
		}
		
		return true;
		
	}

}

