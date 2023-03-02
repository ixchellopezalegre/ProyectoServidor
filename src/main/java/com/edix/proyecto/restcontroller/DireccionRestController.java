package com.edix.proyecto.restcontroller;

import java.util.List;

import com.edix.proyecto.model.dto.UsuarioDTO;
import com.edix.proyecto.model.dto.UsuarioDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.proyecto.model.dto.DireccionDTO;
import com.edix.proyecto.model.dto.DireccionDTOService;

@RestController
@RequestMapping("/rest/provincias")
public class DireccionRestController {
	
	@Autowired
	DireccionDTOService dServ;

    @Autowired
    UsuarioDTOService uServ;
	
    @GetMapping("/todas")
    public List<DireccionDTO> verTodas() {
        return dServ.buscarTodas();
    }

    @GetMapping("/buscar/{provincia}")
    public String buscarPorProvincia(@PathVariable String provincia) {
        return "Tenemos " + dServ.contarClientesPorLocalidad(provincia) + " clientes en " + provincia + ".";
    }

    @GetMapping("/prueba/{provincia}")
     public List<UsuarioDTO>  pruebaPorProvincia(@PathVariable String provincia) {
        return uServ.buscarPorProvincia(provincia);
