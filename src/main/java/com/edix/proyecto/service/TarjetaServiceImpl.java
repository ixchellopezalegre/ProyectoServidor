package com.edix.proyecto.service;

import com.edix.proyecto.beans.Tarjeta;
import com.edix.proyecto.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaServiceImpl implements TarjetaService{

    @Autowired
    TarjetaRepository tRepo;

    @Override
    public boolean registrarTarjeta(Tarjeta tarjeta) {
        tRepo.save(tarjeta);
        return true;

    }
}
