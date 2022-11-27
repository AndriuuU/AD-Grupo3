package com.gestioncursos.model;

import java.util.Arrays;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gestioncursos.entity.Administradores;

public class NoticiasModel {

	private int idnoticias;
	
	private String titulo;
	
	private String descripcion;
	
	private byte[] imagen;

	public NoticiasModel() {
		super();
	}

	public NoticiasModel(int idnoticias, String titulo, String descripcion, byte[] imagen) {
		super();
		this.idnoticias = idnoticias;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public int getIdnoticias() {
		return idnoticias;
	}

	public void setIdnoticias(int idnoticias) {
		this.idnoticias = idnoticias;
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

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "NoticiasModel [idnoticias=" + idnoticias + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", imagen=" + Arrays.toString(imagen) + "]";
	}

}
