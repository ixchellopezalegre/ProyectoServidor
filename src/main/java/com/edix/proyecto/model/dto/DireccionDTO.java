package com.edix.proyecto.model.dto;

import java.io.Serializable;

public class DireccionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String localidad;
	

	public DireccionDTO() {
		super();
	}

	public DireccionDTO(String localidad) {
		super();
		this.localidad = localidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public String toString() {
		return "DireccionDTO [localidad=" + localidad + "]";
	}

}
