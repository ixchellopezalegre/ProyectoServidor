package com.edix.proyecto.service;

import com.edix.proyecto.beans.Tarjeta;
import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarjetaServiceImpl implements TarjetaService{

    @Autowired TarjetaRepository tRepo;
    @Autowired UsuarioServiceImpl uServ;

    //Busqueda de todas las tarjetas que tenemos en la base de datos.
    @Override
    public List<Tarjeta> buscarTodas() {
        return tRepo.findAll();
    }

    //Busqueda de tarjeta por id de tarjeta.
    @Override
    public Tarjeta buscarTarjeta(int idTarjeta) {
        return tRepo.findById(idTarjeta).orElse(null);
    }

    //Recuperar el listado de tarjetas del usuario que tenemos en sesión
    @Override
    public List<Tarjeta> buscarTodasSesion(int idUsuario) {
        List<Tarjeta> tarjetas = uServ.buscarUsuario(idUsuario).getTarjetas();
        System.out.println("Tarjetas del usuario: " + tarjetas);
        return tarjetas;
    }

    //Metodo para registrar una nueva tarjeta
    @Override
    public int registrarTarjeta(Tarjeta tarjeta) {
        try {
            if (compararTarjeta(tarjeta) != -1) {
                int idTarjeta = compararTarjeta(tarjeta);
                System.out.println("OK: La tarjeta ya existe.");
                return idTarjeta;
            } else {
                tRepo.save(tarjeta);
                tRepo.findAll().get(tRepo.findAll().size() - 1);
                System.out.println("OK: Se ha registrado la tarjeta.");
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Error: No se ha registrado la tarjeta.");
            e.printStackTrace();
            return -1;
        }
    }

    //Método de actualización de una tarjeta
    @Override
    public boolean actualizarTarjeta(Tarjeta tarjeta) {
        boolean resultado = false;
        Tarjeta tar = buscarTarjeta(tarjeta.getIdTarjeta());
        try {
            tar.setTitular(tarjeta.getTitular());
            tar.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
            tar.setFechaCaducidad(tarjeta.getFechaCaducidad());
            tar.setCcv(tarjeta.getCcv());
            tRepo.save(tar);
            System.out.println("Se ha actualizado la tarjeta.");
            resultado = true;
        } catch (Exception e) {
            System.out.println("No se ha actualizado la tarjeta.");
            e.printStackTrace();
        }
        return resultado;
    }

    //Borrado de una tarjeta
    @Override
    public boolean borrarTarjeta(int idTarjeta, int idUsuario) {
        try {
            //Buscamois el usuario que tiene la tarjeta
            Usuario user = uServ.buscarUsuario(idUsuario);

            if (user.getTarjetas().remove(buscarTarjeta(idTarjeta))) {
                uServ.actualizarUsuario(user);
                System.out.println("Se ha borrado la tarjeta de la lista de tarjetas del usuario");

                //Si la tarjeta solo está en la lista del usuario, la borramos del sistema
                Optional<Tarjeta> tarjeta = tRepo.findById(idTarjeta);
                if (tarjeta.isPresent()) {
                    if (tarjetaUnica(tarjeta.get())) {
                        tRepo.delete(tarjeta.get());
                        System.out.println("Se ha borrado la tarjeta del sistema completamente");
                        return true;
                    }
                    System.out.println("SOLO se ha borrado la tarjeta en la lista del usuario logueado");
                    return true;
                }
                System.out.println("No se ha encontrado la tarjeta.");
                return false;
            } else {
                System.out.println("No se pudo borrar la tarjeta del usuario.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ha habido un error.");
            return false;
        }
    }

    private int compararTarjeta(Tarjeta tarjeta) {
        List<Tarjeta> tarjetas = buscarTodas();
        for (Tarjeta t : tarjetas) {
            if (t.getNumeroTarjeta().equals(tarjeta.getNumeroTarjeta())) {
                return t.getIdTarjeta();
            }
        }
        return -1;
    }

    private boolean tarjetaUnica(Tarjeta tarjeta){
        boolean resultado = false;
        Tarjeta tar = buscarTarjeta(tarjeta.getIdTarjeta());
        System.out.println("Cantidad de usuarios que tienen esta tarjeta: " + tar.getUsuarios().size());
        System.out.println("Usuarios que tienen esta direccion: " + tar.getUsuarios().toString());
        if(tar.getUsuarios().size() == 0){
            resultado = true;
        }
        return resultado;
    }
}
