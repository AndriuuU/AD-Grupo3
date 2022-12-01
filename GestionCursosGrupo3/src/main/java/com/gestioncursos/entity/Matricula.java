package com.gestioncursos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="matricula")
public class Matricula {

	@Id
	@Column(name="idmatricula")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idmatricula;
	
	@OneToOne
	@JoinColumn(name="idAlumno")
	private Alumnos alumnos;
	
	@ManyToOne
	@JoinColumn(name="idcursos")
	private Cursos cursos;

	public Matricula() {
		super();
	}

	public Matricula(int idmatricula, Alumnos alumnos, Cursos cursos) {
		super();
		this.idmatricula = idmatricula;
		this.alumnos = alumnos;
		this.cursos = cursos;
	}

	public int getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}

	public Alumnos getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumnos alumnos) {
		this.alumnos = alumnos;
	}

	public Cursos getCursos() {
		return cursos;
	}

	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Matricula [idmatricula=" + idmatricula + ", alumnos=" + alumnos + ", cursos=" + cursos + "]";
	}
	
}
