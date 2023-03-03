package com.edix.proyecto.restcontroller;


import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.model.dto.ProductoDTO;
import com.edix.proyecto.model.dto.ProductoDTOServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/producto")
public class ProductoRestController {
	
    @Autowired
    ProductoDTOServiceImpl pServ;
    

    @GetMapping("/buscar/{id}")
    public ProductoDTO buscarPorId(@PathVariable int id) {
        return pServ.buscarPorId(id);
    }
    
    @GetMapping("/tipo/{tipo}")
    public List<Producto> buscarTipo(@PathVariable("tipo") String descripcion){
    	
    	List<Producto> lista = pServ.bucarTipo(descripcion);
    	return lista;
    }
    
  
    
    
    
}
