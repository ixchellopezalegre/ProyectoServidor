package com.edix.proyecto.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.edix.proyecto.beans.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.proyecto.beans.Direccion;
import com.edix.proyecto.repository.DireccionRepository;
@Service
public class DireccionDTOServiceImpl implements DireccionDTOService {

	@Autowired
	DireccionRepository dRepo;
	@Autowired
	UsuarioDTOService uServ;

	@Override
	public List<DireccionDTO> buscarTodas() {
		List<Direccion> dirs = dRepo.findAll();
		List<DireccionDTO> dirsDTO = new ArrayList<>();
		for (Direccion direccion : dirs) {
			dirsDTO.add(convertirDireccionDTO(direccion));
		}
		return dirsDTO;
	}

    private DireccionDTO convertirDireccionDTO(Direccion direccion){

    	DireccionDTO ddto = new DireccionDTO();
    	ddto.setLocalidad(direccion.getLocalidad());
        return ddto;
    }

	
}
