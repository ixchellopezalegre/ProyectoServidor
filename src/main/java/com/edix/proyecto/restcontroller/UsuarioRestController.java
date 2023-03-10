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

	@Autowired UsuarioDTOService uServ;

    //Recuperamos una lita de usuarios que pertenezcan a una misma provincia.
    @GetMapping("/find/{provincia}")
    public List<UsuarioDTO> buscarPorProvincia(@PathVariable String provincia) {
        return uServ.findByProvincia(provincia);
    }
    //Recuperamos una lista de usuarios que pertenezcan a una misma localidad.
    @GetMapping("/buscar/{localidad}")
    public List<Object[]> buscarPorLocalidad(@PathVariable String localidad){
    	return uServ.buscarPorProvincia(localidad);
    }

    @GetMapping("/todos")
    public List<UsuarioDTO> buscarTodos(){
    	return uServ.buscarTodos();
    }
    
    
    
}
