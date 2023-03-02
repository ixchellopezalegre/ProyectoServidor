package com.edix.proyecto.controller;


import com.edix.proyecto.beans.Tarjeta;
import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.TarjetaServiceImpl;
import com.edix.proyecto.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/tarjeta")
public class TarjetaController {

    @Autowired
    TarjetaServiceImpl tServ;
    @Autowired
    UsuarioServiceImpl uServ;

    @GetMapping("/todas")
    public String buscarTodas(Authentication aut, Model model) {
        int idUsuario = uServ.buscarPorEmail(aut.getName()).getIdUsuario();
        model.addAttribute("tarjetas", tServ.buscarTodasSesion(idUsuario));
        return "listaTarjetas";
    }

    @GetMapping("/nueva")
    public String mostrarFormulario() { return "formTarjeta";    }

    @PostMapping("/nueva")
    public String registrarTarjeta (Tarjeta tarjeta,
                                    Authentication aut, RedirectAttributes ratt){
        Usuario usuario = uServ.buscarPorEmail(aut.getName());
        switch (tServ.registrarTarjeta(tarjeta)) {
            case -1:
                ratt.addFlashAttribute("mensaje", "Error al registrar la tarjeta");
                break;
            case 0:
                ratt.addFlashAttribute("mensaje", "Tarjeta registrada correctamente");
                Tarjeta tarjetaAnadida = tServ.buscarTodas().get(tServ.buscarTodas().size()-1);

                if(uServ.anadirTarjeta(usuario, tarjetaAnadida)) {
                    ratt.addFlashAttribute("mensaje", "Tarjeta añadida correctamente");
                } else {
                    ratt.addFlashAttribute("mensaje", "Error al registrar la tarjeta, ya existe en dicho usuario");
                }
                break;
            default:
                ratt.addFlashAttribute("mensaje", "la tarjeta ya existe");
                int idTarjeta = tServ.registrarTarjeta(tarjeta);
                Tarjeta tarjetaExiste = tServ.buscarTarjeta(idTarjeta);

                if(uServ.anadirTarjeta(usuario, tarjetaExiste)) {
                    ratt.addFlashAttribute("mensaje", "Tarjeta añadida correctamente");
                } else {
                    ratt.addFlashAttribute("mensaje", "Error al registrar la tarjeta, ya existe en dicho usuario");
                }

                break;
            }
        return "redirect:/tarjeta/todas";
    }

    @GetMapping("/editar/{idTarjeta}")
    public String mostrarFormularioEditar(@PathVariable int idTarjeta, Model model) {
        model.addAttribute("tarjeta", tServ.buscarTarjeta(idTarjeta));
        return "formTarjetaEditar";
    }

    @PostMapping("/editar/{idTarjeta}")
    public String actualizarTarjeta(@PathVariable int idTarjeta, Tarjeta tarjeta, RedirectAttributes ratt) {
        tarjeta.setIdTarjeta(idTarjeta);
        if (tServ.actualizarTarjeta(tarjeta)) {
            ratt.addFlashAttribute("mensaje", "Tarjeta actualizada correctamente");
        } else {
            ratt.addFlashAttribute("mensaje", "Error al actualizar la tarjeta");
        }
        return "redirect:/tarjeta/todas";
    }

    @GetMapping("/eliminar/{idTarjeta}")
    public String eliminarTarjeta(@PathVariable int idTarjeta,
                                  Authentication aut,
                                  RedirectAttributes ratt) {

        Usuario usuario = uServ.buscarPorEmail(aut.getName());
        int idUsuario = usuario.getIdUsuario();
        if (tServ.borrarTarjeta(idTarjeta, idUsuario)) {
            ratt.addFlashAttribute("mensaje", "Tarjeta eliminada correctamente");
        } else {
            ratt.addFlashAttribute("mensaje", "Error al eliminar la tarjeta");
        }
        return "redirect:/tarjeta/todas";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
