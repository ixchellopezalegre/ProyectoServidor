package com.edix.proyecto.modelo.beans;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "direcciones")
public class Direccione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIRECCION", nullable = false)
    private Integer id;

    @Column(name = "CODIGO_POSTAL", nullable = false, length = 10)
    private String codigoPostal;

    @Column(name = "LOCALIDAD", length = 45)
    private String localidad;

    @Column(name = "CALLE", nullable = false, length = 45)
    private String calle;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @Column(name = "PISO")
    private Integer piso;

    @Column(name = "PUERTA", length = 5)
    private String puerta;

    @ManyToMany
    @JoinTable(name = "usuarios_con_direcciones",
            joinColumns = @JoinColumn(name = "ID_DIRECCION"),
            inverseJoinColumns = @JoinColumn(name = "ID_USUARIO"))
    private Set<Usuario> usuarios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idDireccion")
    private Set<Pedido> pedidos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}