package com.edix.proyecto.controller;

import com.edix.proyecto.beans.Direccion;
import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.service.DireccionService;
import com.edix.proyecto.service.DireccionServiceImpl;
import com.edix.proyecto.service.UsuarioService;
import com.edix.proyecto.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/direccion")
public class DireccionController {
    @Autowired DireccionService dServ;
    @Autowired UsuarioService uServ;

    /***
     * Busca todas las direcciones de un usuario
     * @param Authentication aut, para recuperar el email del usuario
     * @param model, para mandar la lista de direcciones encontradas al JSP
     * @return Página JSP de lista de direcciones.
     */
    @GetMapping("/todas")
    public String buscarTodas(Authentication aut, Model model) {
        int idUsuario = uServ.buscarPorEmail(aut.getName()).getIdUsuario();
        model.addAttribute("direcciones", dServ.buscarTodasSesion(idUsuario));
        return "listaDirecciones";
    }

    @GetMapping("/nueva")
    public String mostrarFormulario() {
        return "formDireccion";
    }

    /**
     *  Registra una dirección y la añade al usuario
     * @param Objeto direccion, para construir un objeto con todos los datos de la dirección
     * @param Authentication aut, para recuperar el email del usuario que tenemos en sesión
     * @param RedirectAtributes ratt, para mandar mensajes de error o éxito
     * @return Volvemos a URL de todas las direcciones registradas.
     */
    @PostMapping("/nueva")
    public String registrarDireccion(Direccion direccion, Authentication aut, RedirectAttributes ratt) {
        Usuario usuario = uServ.buscarPorEmail(aut.getName());
        switch (dServ.registrarDireccion(direccion)) {
            case -1:
                ratt.addFlashAttribute("mensaje", "Error al registrar la dirección");
                break;
            case 0:
                ratt.addFlashAttribute("mensaje", "Dirección registrada correctamente");
                Direccion direccionAnadida = dServ.buscarTodas().get(dServ.buscarTodas().size()-1);

                if(uServ.anadirDireccion(usuario, direccionAnadida)) {
                    ratt.addFlashAttribute("mensaje", "Dirección añadida correctamente");
                } else {
                    ratt.addFlashAttribute("mensaje", "Error al registrar la dirección, ya existe en dicho usuario");
                }
                break;
            default:
                ratt.addFlashAttribute("mensaje", "la direccion ya existe");
                int idDireccion = dServ.registrarDireccion(direccion);
                Direccion direcionExiste = dServ.buscarDireccion(idDireccion);

                if(uServ.anadirDireccion(usuario, direcionExiste)) {
                    ratt.addFlashAttribute("mensaje", "Dirección añadida correctamente");
                } else {
                    ratt.addFlashAttribute("mensaje", "Error al registrar la dirección, ya existe en dicho usuario");
                }

                break;
        }
        return "redirect:/direccion/todas";
    }

    @GetMapping("/editar/{idDireccion}")
    public String mostrarFormularioEditar(@PathVariable int idDireccion, Model model) {
        model.addAttribute("direccion", dServ.buscarDireccion(idDireccion));
        return "formDireccionEditar";
    }

    /**
     * Actualiza una dirección
     * @param PathVariable idDireccion, para recuperar el id de la dirección a actualizar
     * @param Objeto direccion, para construir un objeto con todos los datos de la dirección
     * @param RedirectAtributes ratt, para mandar mensajes de error o éxito a otra página JSP.
     * @return Volvemos a la URL de todas las direcciones registradas.
     */
    @PostMapping("/editar/{idDireccion}")
    public String actualizarDireccion(@PathVariable int idDireccion,
                                      Direccion direccion,
                                      RedirectAttributes ratt) {

        direccion.setIdDireccion(idDireccion);
        if(dServ.actualizarDireccion(direccion)) {
            ratt.addFlashAttribute("mensaje", "Dirección actualizada correctamente");
        } else {
            ratt.addFlashAttribute("mensaje", "Error al actualizar la dirección");
        }
        return "redirect:/direccion/todas";
    }

    /**
     * Elimina una dirección, dependiendo del usuario que este en sesión y de la dirección que seleccione
     * @param PathVariable idDireccion, para recuperar el id de la dirección a eliminar
     * @param aut para recuperar el email del usuario que tenemos en sesión
     * @param ratt para mandar mensajes de error o éxito a otra página JSP.
     * @return URL de la lista de todas las direcciones registradas.
     */
    @GetMapping("/eliminar/{idDireccion}")
    public String eliminarDireccion(@PathVariable int idDireccion,
                                    Authentication aut,
                                    RedirectAttributes ratt) {

        Usuario usuario = uServ.buscarPorEmail(aut.getName());
        int idUsuario = usuario.getIdUsuario();

        if(dServ.borrarDireccion(idDireccion, idUsuario)) {
            ratt.addFlashAttribute("mensaje", "Dirección eliminada correctamente");
        } else {
            ratt.addFlashAttribute("mensaje", "Error al eliminar la dirección");
        }
        return "redirect:/direccion/todas";
    }
}
