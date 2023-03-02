package com.edix.proyecto.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idProducto;
    private String nombre;

    private BigDecimal precio;

    public ProductoDTO() {
        super();
    }

    public ProductoDTO(Integer idProducto, String nombre, BigDecimal precio) {
        super();
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "ProductoDTO [idProducto=" + idProducto + ", nombre=" + nombre +
                ", precio=" + precio + "]";
    }
}
