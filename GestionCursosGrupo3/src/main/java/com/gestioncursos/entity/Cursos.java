package com.gestioncursos.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cursos {

	@Id
	@GeneratedValue
	private int idcursos;
	
	private String nombre;
	
	private String descripcion;
	
	private int nivel;
	
	private Profesores idprofesor;
	
	private Date fechaInicio;
	
	private Date fechaFin;

	public Cursos() {
		super();
	}

	public Cursos(int idcursos, String nombre, String descripcion, int nivel, Profesores idprofesor, Date fechaInicio,
			Date fechaFin) {
		super();
		this.idcursos = idcursos;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.idprofesor = idprofesor;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public int getIdcursos() {
		return idcursos;
	}

	public void setIdcursos(int idcursos) {
		this.idcursos = idcursos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Profesores getIdprofesor() {
		return idprofesor;
	}

	public void setIdprofesor(Profesores idprofesor) {
		this.idprofesor = idprofesor;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Cursos [idcursos=" + idcursos + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel="
				+ nivel + ", idprofesor=" + idprofesor + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ "]";
	}
	
	
}
