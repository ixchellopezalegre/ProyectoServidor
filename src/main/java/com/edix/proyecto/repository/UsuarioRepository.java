package com.edix.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.proyecto.beans.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByEmail(String email);
    
    @Query("SELECT u.idUsuario, u.nombre FROM Usuario u WHERE u.idUsuario IN "
            + "(SELECT u2.idUsuario FROM Usuario u2 JOIN u2.direcciones d WHERE d.localidad = ?1)")
    List<Object[]> buscarPorLocalidad(String localidad);

    
}
