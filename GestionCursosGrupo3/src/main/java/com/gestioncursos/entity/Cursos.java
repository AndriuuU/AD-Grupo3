package com.gestioncursos.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cursos {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCurso;
	private String nombre;
	private String descripcion;
	private int nivel;
	private Date fechaInicio;
	private Date fechaFin;
	
	@ManyToOne
	@JoinColumn(name="profesorId")
	private Profesores profesor;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="curso")
	private List<Comentarios> comentarioList;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="curso")
	private List<Matricula> matriculaList;
	
	public Cursos() {
		super();
	}

	public Cursos(int idCurso, String nombre, String descripcion, int nivel, Date fechaInicio, Date fechaFin,
			Profesores profesor, List<Comentarios> comentarioList, List<Matricula> matriculaList) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.profesor = profesor;
		this.comentarioList = comentarioList;
		this.matriculaList = matriculaList;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
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

	public Profesores getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesores profesor) {
		this.profesor = profesor;
	}

	public List<Comentarios> getComentarioList() {
		return comentarioList;
	}

	public void setComentarioList(List<Comentarios> comentarioList) {
		this.comentarioList = comentarioList;
	}

	public List<Matricula> getMatriculaList() {
		return matriculaList;
	}

	public void setMatriculaList(List<Matricula> matriculaList) {
		this.matriculaList = matriculaList;
	}

	@Override
	public String toString() {
		return "Cursos [idCurso=" + idCurso + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel=" + nivel
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", profesor=" + profesor
				+ ", comentarioList=" + comentarioList + ", matriculaList=" + matriculaList + "]";
	}

	
	
	
	
	
}
