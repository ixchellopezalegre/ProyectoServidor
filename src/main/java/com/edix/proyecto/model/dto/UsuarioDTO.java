package com.edix.proyecto.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioDTO implements Serializable{

	    /*
	    Esta clase es un DTO (Data Transfer Object)
	    que se utiliza para transferir datos entre capas.
	     */
	    private static final long serialVersionUID = 1L;
	    private int idUsuario;
	    private String nombreCompleto;
	    //private String provincia;

	    public UsuarioDTO() {
	    }

	    

		public int getIdUsuario() {
			return idUsuario;
		}


		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}



		public String getNombreCompleto() {
			return nombreCompleto;
		}

		public void setNombreCompleto(String nombreCompleto) {
			this.nombreCompleto = nombreCompleto;
		}

		/*
		 * 
		public String getProvincia() {
			return provincia;
		}

		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}
		*/

		@Override
		public int hashCode() {
			return Objects.hash(idUsuario);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof UsuarioDTO))
				return false;
			UsuarioDTO other = (UsuarioDTO) obj;
			return idUsuario == other.idUsuario;
		}

		@Override
		public String toString() {
			return "UsuarioDTO [idUsuario=" + idUsuario + ", nombreCompleto=" + nombreCompleto 
					//+ ", provincia=" + provincia 
					+ "]";
		}

}
