package com.edix.proyecto.modelo.beans;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO", nullable = false)
    private Integer id;

    @Column(name = "FECHA")
    private Instant fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_TARJETA", nullable = false)
    private Tarjeta idTarjeta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DIRECCION", nullable = false)
    private Direccione idDireccion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    @Lob
    @Column(name = "ESTADO")
    private String estado;

    @OneToMany(mappedBy = "pedido")
    private Set<ProductosEnPedido> productosEnPedidos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public Tarjeta getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Tarjeta idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Direccione getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccione idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<ProductosEnPedido> getProductosEnPedidos() {
        return productosEnPedidos;
    }

    public void setProductosEnPedidos(Set<ProductosEnPedido> productosEnPedidos) {
        this.productosEnPedidos = productosEnPedidos;
    }

}