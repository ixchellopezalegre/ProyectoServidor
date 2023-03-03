package com.edix.proyecto.model.dto;

import java.util.List;

import com.edix.proyecto.beans.Producto;

public interface ProductoDTOService {

    ProductoDTO buscarPorId(int idProducto);
    List<Producto> bucarTipo(String descripcion);

}
