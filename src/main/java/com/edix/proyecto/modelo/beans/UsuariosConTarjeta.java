package com.edix.proyecto.modelo.beans;

import javax.persistence.*;

@Entity
@Table(name = "usuarios_con_tarjetas")
public class UsuariosConTarjeta {
    @EmbeddedId
    private UsuariosConTarjetaId id;

    @MapsId("idTarjeta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_TARJETA", nullable = false)
    private Tarjeta idTarjeta;

    @MapsId("idUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    public UsuariosConTarjetaId getId() {
        return id;
    }

    public void setId(UsuariosConTarjetaId id) {
        this.id = id;
    }

    public Tarjeta getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Tarjeta idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

}