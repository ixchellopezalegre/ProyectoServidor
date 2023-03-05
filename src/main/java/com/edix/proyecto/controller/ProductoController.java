package com.edix.proyecto.controller;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.service.ProductoService;
import com.edix.proyecto.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired ProductoService pServ;

    /**
     * Muestra la lista de todos los productos que tenemos.
     * @param model
     * @return
     */
    @GetMapping("/todos")
    public String buscarTodos(Model model) {
        model.addAttribute("listaProductos", pServ.buscarTodos());
        return "listaProductos";
    }

    /**
     * Muestra un producto en concreto.
     * @param model
     * @param Id de producto dependiendo de la ruta del id del producto.
     * @return Vista en detalle de un producto en JSP.
     */
    @GetMapping("/verUno/{idProducto}")
    public String buscarUno(Model model, @PathVariable int idProducto) {
        model.addAttribute("producto", pServ.buscarUno(idProducto));
        return "verProducto";
    }

    /**
     * Muestra la lista de productos que coinciden con la búsqueda.
     * @param model
     * @param String busqueda, que es el nombre o la descripción del producto asignado al método en repository
     * @return Vista de la lista de productos que coinciden con la búsqueda.
     */
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

    /**
     * Registra un producto en la base de datos.
     * @param Objeto producto, que es el producto que se va a registrar.
     * @return Vuelta a la lista JSP de todos los productos.
     */
    @PostMapping("/alta")
    public String registrarProducto(Producto producto) {
        System.out.println(producto);
        pServ.registrarProducto(producto);
        System.out.println(producto);
        return "redirect:/producto/todos";
    }


    @GetMapping("/editar/{idProducto}")
    public String mostrarModificar(Model model, @PathVariable("idProducto") int idProducto) {
        model.addAttribute("producto", pServ.buscarUno(idProducto));
        return "formProductoEditar";
    }

    /**
     * Modifica un producto en la base de datos.
     * @param producto, objeto completo del nuevo producto que vamos a dar de alta.
     * @return JSP con todos los productos que vamos a dar de alta.
     */
    @PostMapping("/editar")
    public String modificarProducto(Producto producto) {
        System.out.println(producto);
        pServ.modificarProducto(producto);
        System.out.println("comprobamos que se ha modificado");
        System.out.println(pServ.buscarUno(producto.getIdProducto()));
        return "redirect:/producto/todos";
    }

    /**
     * Elimina un producto de la base de datos.
     * @param model
     * @param idProducto del prodicto que vamos a eliminar.
     * @return JSP con el listado de todos los productos que tenemos en nuestra base de datos.
     */
    @GetMapping("/eliminar/{idProducto}")
    public String borrarProducto(Model model, @PathVariable int idProducto) {
        if (pServ.borrarProducto(idProducto) == true) {
            model.addAttribute("mensaje", "Producto eliminado");
        } else model.addAttribute("mensaje", "Producto no eliminado");
        return "forward:/producto/todos";
    }

    // Ordenar productos en sentido ascendente.
    @GetMapping("/orden/alfabetico/asc")
    public String ordenarAlfaAsc(Model model) {
    	model.addAttribute("listaProductos", pServ.ordenarAlfabeticamenteAsc());
    	return "listaProductos";
    }

    //Ordena la lista de productos por orden alfabético descendente
    @GetMapping("/orden/alfabetico/desc")
    public String ordenarAlfaDesc(Model model) {
    	model.addAttribute("listaProductos", pServ.ordenarAlfabeticamenteDesc());
    	return "listaProductos";
    }

    //Ordena la lista de productos por precio más alto
    @GetMapping("/orden/precio/asc")
    public String ordenarPorPrecio(Model model) {
        model.addAttribute("listaProductos", pServ.ordenarPorPrecioAsc());
        return "listaProductos";
    }

    //Ordena la lista de productos por precio más bajo
    @GetMapping("/orden/precio/desc")
    public String ordenarPorPrecioDesc(Model model) {
        model.addAttribute("listaProductos", pServ.ordenarPorPrecioDesc());
        return "listaProductos";
    }

}
