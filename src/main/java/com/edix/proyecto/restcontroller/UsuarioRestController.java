package com.edix.proyecto.restcontroller;

import java.util.List;

import com.edix.proyecto.model.dto.DireccionDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.proyecto.model.dto.UsuarioDTO;
import com.edix.proyecto.model.dto.UsuarioDTOService;

@RestController
@RequestMapping("/rest/usuarios")
public class UsuarioRestController {

	@Autowired
	UsuarioDTOService uServ;

    @GetMapping("/find/{provincia}")
    public List<UsuarioDTO> buscarPorProvincia(@PathVariable String provincia) {
        return uServ.findByProvincia(provincia);
    }
    
    @GetMapping("/buscar/{localidad}")
    public List<Object[]> buscarPorLocalidad(@PathVariable String localidad){
    	return uServ.buscarPorProvincia(localidad);
    }
    
    
    
}
