package com.edix.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository pRepo;

	@Override
	public List<Producto> buscarTodos() {
		return pRepo.findAll();
	}

	@Override
	public Producto buscarUno(int idProducto) {
		return pRepo.findById(idProducto).orElse(null);
	}

	@Override
	public Producto buscarPorNombre(String nombre) {
		return pRepo.findByNombre(nombre);
	}

	@Override
	public List<Producto> buscarPorNombreODescripcion(String nombre) {
		return pRepo.findByNombreOrDescripcionContainsIgnoreCase(nombre);
	}
	@Override
	public boolean registrarProducto(Producto producto) {
		Optional<Producto> productoExistente = pRepo.findById(producto.getIdProducto());

		if (productoExistente.isEmpty()) {
			pRepo.save(producto);
			return true;
		}
		return false;
	}

	@Override
	public boolean borrarProducto(int idProducto) {
		try {
			pRepo.deleteById(idProducto);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

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

}

