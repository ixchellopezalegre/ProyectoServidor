package com.edix.proyecto.modelo.beans;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuariosConDireccioneId implements Serializable {
    private static final long serialVersionUID = 406127184435409151L;
    @Column(name = "ID_USUARIO", nullable = false)
    private Integer idUsuario;

    @Column(name = "ID_DIRECCION", nullable = false)
    private Integer idDireccion;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuariosConDireccioneId entity = (UsuariosConDireccioneId) o;
        return Objects.equals(this.idDireccion, entity.idDireccion) &&
                Objects.equals(this.idUsuario, entity.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDireccion, idUsuario);
    }

}