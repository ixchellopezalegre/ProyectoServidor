package com.edix.proyecto.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USUARIO")
	private int idUsuario;

	private String apellidos;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	private String nombre;

	private String password;

	//uni-directional many-to-many association to Direccion
	@ManyToMany
	@JoinTable(
		name="usuarios_con_direcciones"
		, joinColumns={
			@JoinColumn(name="ID_USUARIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_DIRECCION")
			}
		)
	private List<Direccion> direcciones;

	//uni-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="usuarios_con_roles"
		, joinColumns={
			@JoinColumn(name="ID_USUARIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_ROL")
			}
		)
	private List<Rol> roles;

	//uni-directional many-to-many association to Tarjeta
	@ManyToMany
	@JoinTable(
		name="usuarios_con_tarjetas"
		, joinColumns={
			@JoinColumn(name="ID_USUARIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_TARJETA")
			}
		)
	private List<Tarjeta> tarjetas;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Direccion> getDirecciones() {
		return this.direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public List<Rol> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public List<Tarjeta> getTarjetas() {
		return this.tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

}