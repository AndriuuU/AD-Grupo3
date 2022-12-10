package com.gestioncursos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comentarios {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idComentarios;
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name="cursoId")
	private Cursos curso;
	
	@ManyToOne
	@JoinColumn(name="alumnoId")
	private Alumnos alumno;

	
	public Comentarios() {
		super();
	}


	public Comentarios(int idComentarios, String comentario, Cursos curso, Alumnos alumno) {
		super();
		this.idComentarios = idComentarios;
		this.comentario = comentario;
		this.curso = curso;
		this.alumno = alumno;
	}


	public int getIdComentarios() {
		return idComentarios;
	}


	public void setIdComentarios(int idComentarios) {
		this.idComentarios = idComentarios;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
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
		return "Comentario [idComentarios=" + idComentarios + ", comentario=" + comentario + ", curso=" + curso
				+ ", alumno=" + alumno + "]";
	}
	
	
}
