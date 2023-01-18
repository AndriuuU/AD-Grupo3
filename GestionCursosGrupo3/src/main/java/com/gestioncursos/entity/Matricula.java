package com.gestioncursos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMatricula;
	private float valoracion;

	@ManyToOne
	@JoinColumn(name = "cursoId")
	private Cursos curso;

	@ManyToOne
	@JoinColumn(name = "alumnoId")
	private Alumnos alumno;

	public Matricula() {
		super();
	}

	public Matricula(int idMatricula, float valoracion, Cursos curso, Alumnos alumno) {
		super();
		this.idMatricula = idMatricula;
		this.valoracion = valoracion;
		this.curso = curso;
		this.alumno = alumno;
	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	public Alumnos getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "Matricula [idMatricula=" + idMatricula + ", valoracion=" + valoracion + ", curso=" + curso + ", alumno="
				+ alumno + "]";
	}

	
	

}
