package com.edix.proyecto.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@Table(name="pedidos")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PEDIDO")
	private int idPedido;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	//uni-directional many-to-one association to Direccion
	@ManyToOne
	@JoinColumn(name="ID_DIRECCION")
	private Direccion direccion;

	//uni-directional many-to-one association to Tarjeta
	@ManyToOne
	@JoinColumn(name="ID_TARJETA")
	private Tarjeta tarjeta;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to ProductosEnPedido
	@OneToMany(mappedBy="pedido")
	private List<ProductosEnPedido> productosEnPedidos;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccione(Direccion direccion) {
		this.direccion = direccion;
	}

	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProductosEnPedido> getProductosEnPedidos() {
		return this.productosEnPedidos;
	}

	public void setProductosEnPedidos(List<ProductosEnPedido> productosEnPedidos) {
		this.productosEnPedidos = productosEnPedidos;
	}

	public ProductosEnPedido addProductosEnPedido(ProductosEnPedido productosEnPedido) {
		getProductosEnPedidos().add(productosEnPedido);
		productosEnPedido.setPedido(this);

		return productosEnPedido;
	}

	public ProductosEnPedido removeProductosEnPedido(ProductosEnPedido productosEnPedido) {
		getProductosEnPedidos().remove(productosEnPedido);
		productosEnPedido.setPedido(null);

		return productosEnPedido;
	}

}