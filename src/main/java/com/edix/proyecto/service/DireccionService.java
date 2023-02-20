package com.edix.proyecto.service;

import com.edix.proyecto.beans.Direccion;
import com.edix.proyecto.beans.Usuario;

import java.util.List;

public interface DireccionService {
    List<Direccion> buscarTodas();
    Direccion buscarDireccion(int idDireccion);
    List<Direccion> buscarTodasSesion(int idUsuario);
    int registrarDireccion(Direccion direccion);
    boolean actualizarDireccion(Direccion direccion);
    boolean borrarDireccion(int idDireccion, int idUsuario);
}
