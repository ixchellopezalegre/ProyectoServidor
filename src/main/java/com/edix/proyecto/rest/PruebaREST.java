package com.edix.proyecto.rest;

import com.edix.proyecto.beans.Direccion;
import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.DireccionServiceImpl;
import com.edix.proyecto.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prueba")
public class PruebaREST {
    @Autowired
    DireccionServiceImpl dServ;
    @Autowired
    UsuarioServiceImpl uServ;

    @GetMapping("/alta/{idUsuario}")
    public String mostrarFormulario(  Model model, @PathVariable int idUsuario) {
        model.addAttribute("usuario", uServ.buscarUsuario(idUsuario));
        return "formDireccion";
    }

    @PostMapping("/alta")
    public String registrarDireccion(@RequestParam("idUsuario") int idUsuario, Direccion direccion) {
        Usuario user = uServ.buscarUsuario(idUsuario);
        if(dServ.registrarDireccion(direccion)) {
            direccion.getUsuarios().add(user);
            user.getDirecciones().add(direccion);

        }

        return "redirect:/prueba/ver/" + idUsuario;
    }

    @GetMapping("/ver/{idUsuario}")
    public String prueba(Model model, @PathVariable int idUsuario) {
        model.addAttribute("usuario", uServ.buscarUsuario(idUsuario));
        model.addAttribute("direcciones", dServ.buscarTodas(idUsuario));
        return "pruebas";
    }
}
