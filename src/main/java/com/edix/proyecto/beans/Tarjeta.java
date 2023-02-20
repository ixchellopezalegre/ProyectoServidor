package com.edix.proyecto.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


/**
 * The persistent class for the tarjetas database table.
 * 
 */
@Entity
@Table(name="tarjetas")
@NamedQuery(name="Tarjeta.findAll", query="SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TARJETA")
	private int idTarjeta;

	private int ccv;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CADUCIDAD")
	private Date fechaCaducidad;

	@Lob
	@Column(name="NUMERO_TARJETA")
	private String numeroTarjeta;

	private String titular;

	@ManyToMany(mappedBy = "tarjetas")
	private Set<Usuario> usuarios = new LinkedHashSet<>();

	public Tarjeta() {
	}

	public int getIdTarjeta() {
		return this.idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getCcv() {
		return this.ccv;
	}

	public void setCcv(int ccv) {
		this.ccv = ccv;
	}

	public Date getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getNumeroTarjeta() {
		return this.numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getTitular() {
		return this.titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tarjeta tarjeta = (Tarjeta) o;
		return idTarjeta == tarjeta.idTarjeta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTarjeta);
	}

	@Override
	public String toString() {
		return "Tarjeta{" +
				"idTarjeta=" + idTarjeta +
				", ccv=" + ccv +
				", fechaCaducidad=" + fechaCaducidad +
				", numeroTarjeta='" + numeroTarjeta + '\'' +
				", titular='" + titular + '\'' +
				'}';
	}
}