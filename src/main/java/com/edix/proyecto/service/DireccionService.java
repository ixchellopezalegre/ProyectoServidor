package com.edix.proyecto.service;

import com.edix.proyecto.beans.Direccion;

import java.util.List;

public interface DireccionService {

    List<Direccion> buscarTodas(int idUsuario);
    boolean registrarDireccion(Direccion direccion);
}
