package com.edix.proyecto.modelo.beans;

import javax.persistence.*;

@Entity
@Table(name = "usuarios_con_direcciones")
public class UsuariosConDireccione {
    @EmbeddedId
    private UsuariosConDireccioneId id;

    @MapsId("idUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    @MapsId("idDireccion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DIRECCION", nullable = false)
    private Direccione idDireccion;

    public UsuariosConDireccioneId getId() {
        return id;
    }

    public void setId(UsuariosConDireccioneId id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Direccione getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccione idDireccion) {
        this.idDireccion = idDireccion;
    }

}