package com.edix.proyecto.service;

import com.edix.proyecto.beans.Direccion;
import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    DireccionRepository dRepo;
    @Autowired
    UsuarioServiceImpl uServ;

    @Override
    public List<Direccion> buscarTodas() {
        return dRepo.findAll();
    }

    public Direccion buscarDireccion(int idDireccion) {
        return dRepo.findById(idDireccion).orElse(null);
    }

    @Override
    public List<Direccion> buscarTodasSesion(int idUsuario) {
        List<Direccion> direcciones = uServ.buscarUsuario(idUsuario).getDirecciones();
        System.out.println("Direcciones del usuario: " + direcciones);
        return direcciones;
    }

    @Override
    public int registrarDireccion(Direccion direccion) {

        try {
            if (compararDireccion(direccion) != -1) {
                int idDireccion = compararDireccion(direccion);
                System.out.println("OK: La direccion ya existe.");
                return idDireccion;
            } else {
                dRepo.save(direccion);
                dRepo.findAll().get(dRepo.findAll().size() - 1);
                System.out.println("OK: Se ha registrado la direccion.");
                return 0;
            }

        } catch (Exception e) {
            System.out.println("Error: No se ha registrado la direccion.");
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean actualizarDireccion(Direccion direccion) {
        boolean resultado = false;
        Direccion dir = buscarDireccion(direccion.getIdDireccion());
        try {
            dir.setCalle(direccion.getCalle());
            dir.setCodigoPostal(direccion.getCodigoPostal());
            dir.setNumero(direccion.getNumero());
            dir.setPiso(direccion.getPiso());
            dir.setPuerta(direccion.getPuerta());
            dir.setLocalidad(direccion.getLocalidad());
            dir.setCodigoPostal(direccion.getCodigoPostal());
            dRepo.save(dir);
            System.out.println("Se ha actualizado la direccion.");
            resultado = true;
        } catch (Exception e) {
            System.out.println("No se ha actualizado la direccion");
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean borrarDireccion(int idDireccion, int idUsuario) {
        try {
            Usuario user = uServ.buscarUsuario(idUsuario);
            if (user.getDirecciones().remove(buscarDireccion(idDireccion))) {
                uServ.actualizarUsuario(user);
                System.out.println("Se ha borrado la direccion de la lista de direcciones del usuario");

                Optional<Direccion> direccion = dRepo.findById(idDireccion);
                if (direccion.isPresent()) {
                    if (direccionUnica(direccion.get())) {
                        dRepo.delete(direccion.get());
                        System.out.println("Se ha borrado la direccion del sistema completamente");
                        return true;
                    }
                    System.out.println("SOLO se ha borrado la direccion en la lista del usuario logueado");
                    return true;
                }
                System.out.println("No se ha encontrado la direccion.");
                return false;
            }else{
                System.out.println("No se pudo borrar la direccion del usuario.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ha habido un error.");
            return false;
        }
    }


    private int compararDireccion(Direccion direccion){
        int resultado = -1;
        List<Direccion> direcciones = buscarTodas();
        for(Direccion dir : direcciones){
            if(dir.getCalle().equals(direccion.getCalle())
                    && dir.getNumero() == direccion.getNumero()
                    && dir.getPiso() == direccion.getPiso()
                    && dir.getPuerta().equals(direccion.getPuerta())
                    && dir.getCodigoPostal().equals(direccion.getCodigoPostal())
                    && dir.getLocalidad().equals(direccion.getLocalidad())){
                resultado = dir.getIdDireccion();
            }
        }
        return resultado;
    }

    private boolean direccionUnica(Direccion direccion){
        boolean resultado = false;
        Direccion dir = buscarDireccion(direccion.getIdDireccion());
        System.out.println("Cantidad de usuarios que tienen esta direccion: " + dir.getUsuarios().size());
        System.out.println("Usuarios que tienen esta direccion: " + dir.getUsuarios().toString());
        if(dir.getUsuarios().size() == 0){
            resultado = true;
        }
        return resultado;
    }
    
}
