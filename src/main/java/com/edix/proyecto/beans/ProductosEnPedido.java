package com.edix.proyecto.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the productos_en_pedidos database table.
 * 
 */
@Entity
@Table(name="productos_en_pedidos")
@NamedQuery(name="ProductosEnPedido.findAll", query="SELECT p FROM ProductosEnPedido p")
public class ProductosEnPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NUMERO_ORDEN")
	private Integer numeroOrden;

	private int cantidad;

	@Column(name="PRECIO_TOTAL")
	private BigDecimal precioTotal;

	//bi-directional many-to-one association to Pedido
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="ID_PEDIDO")
	private Pedido pedido;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private Producto producto;

	public ProductosEnPedido() {
	}

	public int getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioTotal() {
		return this.precioTotal;
	}

	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}