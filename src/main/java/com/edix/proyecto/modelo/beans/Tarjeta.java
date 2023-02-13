package com.edix.proyecto.modelo.beans;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tarjetas")
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TARJETA", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "NUMERO_TARJETA", nullable = false)
    private String numeroTarjeta;

    @Column(name = "TITULAR", nullable = false, length = 45)
    private String titular;

    @Column(name = "FECHA_CADUCIDAD", nullable = false)
    private LocalDate fechaCaducidad;

    @Column(name = "CCV", nullable = false)
    private Integer ccv;

    @ManyToMany
    @JoinTable(name = "usuarios_con_tarjetas",
            joinColumns = @JoinColumn(name = "ID_TARJETA"),
            inverseJoinColumns = @JoinColumn(name = "ID_USUARIO"))
    private Set<Usuario> usuarios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTarjeta")
    private Set<Pedido> pedidos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Integer getCcv() {
        return ccv;
    }

    public void setCcv(Integer ccv) {
        this.ccv = ccv;
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