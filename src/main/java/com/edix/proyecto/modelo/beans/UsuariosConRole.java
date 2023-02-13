package com.edix.proyecto.modelo.beans;

import javax.persistence.*;

@Entity
@Table(name = "usuarios_con_roles")
public class UsuariosConRole {
    @EmbeddedId
    private UsuariosConRoleId id;

    @MapsId("idRol")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ROL", nullable = false)
    private Role idRol;

    @MapsId("idUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    public UsuariosConRoleId getId() {
        return id;
    }

    public void setId(UsuariosConRoleId id) {
        this.id = id;
    }

    public Role getIdRol() {
        return idRol;
    }

    public void setIdRol(Role idRol) {
        this.idRol = idRol;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

}