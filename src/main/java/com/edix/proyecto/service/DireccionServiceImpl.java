package com.edix.proyecto.service;

import com.edix.proyecto.beans.Direccion;
import com.edix.proyecto.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService{

    @Autowired
    DireccionRepository dRepo;
    @Autowired
    UsuarioServiceImpl uServ;

    @Override
    public List<Direccion> buscarTodas(int idUsuario) {
        List<Direccion> direcciones = uServ.buscarUsuario(idUsuario).getDirecciones();
        return direcciones;
    }
    @Override
    public boolean registrarDireccion(Direccion direccion) {
        Optional<Direccion> direccionExistente = dRepo.findById(direccion.getIdDireccion());

        if (direccionExistente.isEmpty()) {
            dRepo.save(direccion);
            return true;
        }
        return false;
    }

}
