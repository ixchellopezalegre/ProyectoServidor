package com.edix.proyecto.beans;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the direcciones database table.
 * 
 */
@Entity
@Table(name="direcciones")
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DIRECCION")
	private int idDireccion;

	private String calle;

	@Column(name="CODIGO_POSTAL")
	private String codigoPostal;

	private String localidad;

	private Integer numero;

	private Integer piso;

	private String puerta;

	@ManyToMany(mappedBy = "direcciones")
	private List<Usuario> usuarios = new ArrayList<>();


	public Direccion() {
	}

	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getPiso() {
		return this.piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getPuerta() {
		return this.puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idDireccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Direccion))
			return false;
		Direccion other = (Direccion) obj;
		return idDireccion == other.idDireccion;
	}

	@Override
	public String toString() {
		return "Direccion{" +
				"idDireccion=" + idDireccion +
				", calle='" + calle + '\'' +
				", codigoPostal='" + codigoPostal + '\'' +
				", localidad='" + localidad + '\'' +
				", numero=" + numero +
				", piso=" + piso +
				", puerta='" + puerta + '\'' +
				'}';
	}
}