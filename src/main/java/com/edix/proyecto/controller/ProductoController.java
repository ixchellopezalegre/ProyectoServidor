package com.edix.proyecto.controller;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServiceImpl pServ;

    @GetMapping("/todos")
    public String buscarTodos(Model model) {
        model.addAttribute("listaProductos", pServ.buscarTodos());
        return "listaProductos";
    }
    @GetMapping("/verUno/{idProducto}")
    public String buscarUno(Model model, @PathVariable int idProducto) {
        model.addAttribute("producto", pServ.buscarUno(idProducto));
        return "verProducto";
    }

    @GetMapping("/buscar")
    public String buscar(Model model, @RequestParam("busqueda") String busqueda) {

        List<Producto> resultados = pServ.buscarPorNombreODescripcion(busqueda);
        model.addAttribute("resultados", resultados);
        return "resultadosBuscar";
    }
    @GetMapping("/alta")
    public String mostrarRegistro() {
        return "formProducto";
    }

    @PostMapping("/alta")
    public String registrarProducto(Producto producto) {
        System.out.println(producto);
        pServ.registrarProducto(producto);
        System.out.println(producto);
        return "redirect:/producto/todos";
    }

    @GetMapping("/editar/{idProducto}")
    public String mostrarModificar(Model model, @PathVariable int idProducto) {
        model.addAttribute("producto", pServ.buscarUno(idProducto));
        return "formProductoEditar";
    }
    
    @PostMapping("/editar")
    public String modificarProducto(Producto producto) {
        System.out.println(producto);
        pServ.modificarProducto(producto);
        System.out.println("comprobamos que se ha modificado");
        System.out.println(pServ.buscarUno(producto.getIdProducto()));
        return "redirect:/producto/todos";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String borrarProducto(Model model, @PathVariable int idProducto) {
        if (pServ.borrarProducto(idProducto) == true) {
            model.addAttribute("mensaje", "Producto eliminado");
        } else model.addAttribute("mensaje", "Producto no eliminado");
        return "forward:/producto/todos";
    }

}
