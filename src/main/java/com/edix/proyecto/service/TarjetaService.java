package com.edix.proyecto.service;

import com.edix.proyecto.beans.Tarjeta;

import java.util.List;

public interface TarjetaService {
    List<Tarjeta> buscarTodas();

    Tarjeta buscarTarjeta(int idTarjeta);

    List<Tarjeta> buscarTodasSesion(int idUsuario);

    int registrarTarjeta(Tarjeta tarjeta);

    boolean actualizarTarjeta(Tarjeta tarjeta);

    boolean borrarTarjeta(int idTarjeta, int idUsuario);


}

