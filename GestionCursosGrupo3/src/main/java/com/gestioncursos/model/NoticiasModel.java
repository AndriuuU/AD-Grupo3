package com.gestioncursos.model;

import java.util.Arrays;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gestioncursos.entity.Administradores;

public class NoticiasModel {

	private int idNoticia;
	
	private String titulo;
	
	private String descripcion;
	
	private String imagen;
	
	private long idAdmin;

	public NoticiasModel() {
		super();
	}

	public NoticiasModel(int idNoticia, String titulo, String descripcion, String imagen, long idAdmin) {
		super();
		this.idNoticia = idNoticia;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.idAdmin = idAdmin;
	}

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
	}

	@Override
	public String toString() {
		return "NoticiasModel [idNoticia=" + idNoticia + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", idAdmin=" + idAdmin + "]";
	}

	

	
}
