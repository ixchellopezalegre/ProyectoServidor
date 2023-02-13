package com.edix.proyecto.modelo.beans;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuariosConTarjetaId implements Serializable {
    private static final long serialVersionUID = 5308770646834068751L;
    @Column(name = "ID_TARJETA", nullable = false)
    private Integer idTarjeta;

    @Column(name = "ID_USUARIO", nullable = false)
    private Integer idUsuario;

    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuariosConTarjetaId entity = (UsuariosConTarjetaId) o;
        return Objects.equals(this.idTarjeta, entity.idTarjeta) &&
                Objects.equals(this.idUsuario, entity.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarjeta, idUsuario);
    }

}