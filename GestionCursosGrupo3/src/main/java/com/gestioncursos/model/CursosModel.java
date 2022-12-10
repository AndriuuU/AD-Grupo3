package com.gestioncursos.model;

import java.sql.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gestioncursos.entity.Profesores;

public class CursosModel {

	private int idcursos;

	private String nombre;
	
	private String descripcion;
	
	private int nivel;
	
	private int idProfesor;
	
	private Date fechaInicio;
	
	private Date fechaFin;

	public CursosModel() {
		super();
	}

	public CursosModel(int idcursos, String nombre, String descripcion, int nivel , int idProfesor, Date fechaInicio,
			Date fechaFin) {
		super();
		this.idcursos = idcursos;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.idProfesor = idProfesor;
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

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
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
		return "CursosModel [idcursos=" + idcursos + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel="
				+ nivel + ", idProfesor=" + idProfesor + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ "]";
	}

	

}
