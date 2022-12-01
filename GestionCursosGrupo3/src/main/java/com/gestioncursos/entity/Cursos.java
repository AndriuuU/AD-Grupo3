package com.gestioncursos.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cursos")
public class Cursos {

	@Id
	@Column(name="idcursos")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcursos;
	
	@Column(name="nombre", length=45)
	private String nombre;
	
	@Column(name="descripcion", length=45)
	private String descripcion;
	
	private int nivel;
	
	@OneToMany(mappedBy="idprofesores", cascade=CascadeType.ALL)
	private List<Profesores> profesores;
	
	private Date fechaInicio;
	
	private Date fechaFin;

	public Cursos() {
		super();
	}

	public Cursos(int idcursos, String nombre, String descripcion, int nivel, List<Profesores> profesores,
			Date fechaInicio, Date fechaFin) {
		super();
		this.idcursos = idcursos;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.profesores = profesores;
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

	public List<Profesores> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesores> profesores) {
		this.profesores = profesores;
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
				+ nivel + ", profesores=" + profesores + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ "]";
	}
	
}
