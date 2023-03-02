package com.edix.proyecto.model.dto;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoDTOServiceImpl implements ProductoDTOService{

    @Autowired
    private ProductoRepository pRepo;

    @Override
    public ProductoDTO buscarPorId(int idProducto) {
        Producto producto = pRepo.findById(idProducto).get();
        return convertirProductoDTO(producto);
    }

    private ProductoDTO convertirProductoDTO(Producto producto){
        ProductoDTO pdto = new ProductoDTO();
        pdto.setIdProducto(producto.getIdProducto());
        pdto.setNombre(producto.getNombre());
        pdto.setPrecio(producto.getPrecio());
        return pdto;
    }
}
