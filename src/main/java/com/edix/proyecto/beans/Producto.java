package com.edix.proyecto.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PRODUCTO")
	private int idProducto;

	private String descripcion;

	private String nombre;

	private BigDecimal precio;

	private int stock;

	//bi-directional many-to-one association to ProductosEnPedido
	@OneToMany(mappedBy="producto")
	private List<ProductosEnPedido> productosEnPedidos;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<ProductosEnPedido> getProductosEnPedidos() {
		return this.productosEnPedidos;
	}

	public void setProductosEnPedidos(List<ProductosEnPedido> productosEnPedidos) {
		this.productosEnPedidos = productosEnPedidos;
	}

	public ProductosEnPedido addProductosEnPedido(ProductosEnPedido productosEnPedido) {
		getProductosEnPedidos().add(productosEnPedido);
		productosEnPedido.setProducto(this);

		return productosEnPedido;
	}

	public ProductosEnPedido removeProductosEnPedido(ProductosEnPedido productosEnPedido) {
		getProductosEnPedidos().remove(productosEnPedido);
		productosEnPedido.setProducto(null);

		return productosEnPedido;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Producto producto = (Producto) o;
		return idProducto == producto.idProducto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}

	@Override
	public String toString() {
		return "Producto{" +
				"idProducto=" + idProducto +
				", descripcion='" + descripcion + '\'' +
				", nombre='" + nombre + '\'' +
				", precio=" + precio +
				", stock=" + stock +
				'}';
	}
}