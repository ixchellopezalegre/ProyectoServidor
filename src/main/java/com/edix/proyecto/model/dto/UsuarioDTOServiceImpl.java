package com.edix.proyecto.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.proyecto.beans.Direccion;
import com.edix.proyecto.beans.Usuario;
import com.edix.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioDTOServiceImpl implements UsuarioDTOService {

    @Autowired
    private UsuarioRepository  uRepo;
    
    
	public List<UsuarioDTO> buscarTodos() {
        List<Usuario> usuarios = uRepo.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios){
            usuariosDTO.add(convertirUsuarioDTO(usuario));
        }
        System.out.println("Usuarios: " + usuariosDTO);
        return usuariosDTO;
	}

    public List<UsuarioDTO> buscarPorProvincia(String provincia) {
        List<Usuario> usuarios = uRepo.
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios){
            usuariosDTO.add(convertirUsuarioDTO(usuario));
        }
        System.out.println("Usuarios: " + usuariosDTO);
        return usuariosDTO;
    }
	
    private UsuarioDTO convertirUsuarioDTO(Usuario usuario){

    	UsuarioDTO udto = new UsuarioDTO();
    	udto.setIdUsuario(usuario.getIdUsuario());
    	udto.setNombreCompleto(usuario.getNombre() + " " + usuario.getApellidos());
    	List<DireccionDTO> provincias = new ArrayList<>();
        List<Direccion> direcciones = usuario.getDirecciones();
        
        for (Direccion direccion : direcciones){
            provincias.add(convertirDireccionDTO(direccion));
        }
        
    	udto.setProvincias(provincias);
        return udto;
    }
    
    private DireccionDTO convertirDireccionDTO(Direccion direccion){

    	DireccionDTO ddto = new DireccionDTO();
    	ddto.setLocalidad(direccion.getLocalidad());
        return ddto;
    }
}
