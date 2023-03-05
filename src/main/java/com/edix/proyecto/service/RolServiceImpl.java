package com.edix.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.proyecto.beans.Rol;
import com.edix.proyecto.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	RolRepository roRepo;

	//Busqueda por id de ROL.
	@Override
	public Rol buscarRol(int idRol) {
		return roRepo.findById(idRol).orElse(null);
	}
	
	

}
