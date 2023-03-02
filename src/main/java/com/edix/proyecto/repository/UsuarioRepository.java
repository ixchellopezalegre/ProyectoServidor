package com.edix.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.proyecto.beans.Usuario;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByEmail(String email);

    @Query("SELECT u FROM Usuario u JOIN u.direcciones d WHERE d.localidad = ?1")
    List<Usuario> findByDirecciones(String localidad);
}
