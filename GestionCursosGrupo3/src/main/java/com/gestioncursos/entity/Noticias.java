package com.gestioncursos.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="noticias")
public class Noticias {

	@Id
	@Column(name="idnoticias")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idnoticias;
	
	@Column(name="titulo", length=45)
	private String titulo;
	
	@Column(name="descripcion", length=45)
	private String descripcion;
	
	@Column(name="imagen", nullable=true)
	private byte[] imagen;
	
	@ManyToOne
	@JoinColumn(name="idAdministrador")
	private Administradores administradores;

	public Noticias() {
		super();
	}

	public Noticias(int idnoticias, String titulo, String descripcion, byte[] imagen, Administradores administradores) {
		super();
		this.idnoticias = idnoticias;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.administradores = administradores;
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

	public Administradores getAdministradores() {
		return administradores;
	}

	public void setAdministradores(Administradores administradores) {
		this.administradores = administradores;
	}

	@Override
	public String toString() {
		return "Noticias [idnoticias=" + idnoticias + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", imagen=" + Arrays.toString(imagen) + ", administradores=" + administradores + "]";
	}
	
}
