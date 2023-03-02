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

    @GetMapping("/todas")
    public List<DireccionDTO> verTodas() {
        return dServ.buscarTodas();
    }

}
