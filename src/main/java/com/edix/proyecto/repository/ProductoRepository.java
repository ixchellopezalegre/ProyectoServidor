package com.edix.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.proyecto.beans.Producto;
import com.edix.proyecto.model.dto.ProductoDTO;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    Producto findByNombre(String nombre);
    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %?1% OR p.descripcion LIKE %?1%")
    List<Producto> findByNombreOrDescripcionContainsIgnoreCase(String nombre);
    @Query("SELECT p FROM Producto p WHERE p.descripcion LIKE %?1%")
    List<Producto>buscarPorTipo(String descripcion);
    List<Producto> findAllByOrderByNombreAsc();
    List<Producto> findAllByOrderByNombreDesc();

    List<Producto> findAllByOrderByPrecioAsc();
    List<Producto> findAllByOrderByPrecioDesc();
    
    
    @Query("SELECT p.stock FROM Producto p WHERE p.idProducto = ?1")
    int verStock(int IdProducto);
    
    
}
