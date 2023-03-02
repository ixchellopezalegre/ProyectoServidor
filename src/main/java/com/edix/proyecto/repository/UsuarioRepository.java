package com.edix.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.proyecto.beans.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByEmail(String email);
    
    
}
