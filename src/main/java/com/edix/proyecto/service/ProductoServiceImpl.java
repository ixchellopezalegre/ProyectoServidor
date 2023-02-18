package com.edix.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.repository.ProductoRepository;

public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository pRepo;

	@Override
	public List<Producto> buscarTodos() {
		return pRepo.findAll();
	}

	@Override
	public Producto buscarProducto(int idProducto) {
		return pRepo.findById(idProducto).orElse(null);
	}

	@Override
	public Producto buscarPorNombre(String nombre) {
		return null;
	}

	@Override
	public boolean registrarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarProducto(int idProducto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}
}
