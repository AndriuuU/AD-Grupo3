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
	private int idcomentarios;
	
	@ManyToOne
	@JoinColumn(name="idAlumno")
	private Alumnos alumnos;
	
	@ManyToOne
	@JoinColumn(name="idCurso")
	private Cursos curso;
	
	private String comentario;

	public Comentarios() {
		super();
	}

	public Comentarios(int idcomentarios, Alumnos alumnos, Cursos curso, String comentario) {
		super();
		this.idcomentarios = idcomentarios;
		this.alumnos = alumnos;
		this.curso = curso;
		this.comentario = comentario;
	}

	public int getIdcomentarios() {
		return idcomentarios;
	}

	public void setIdcomentarios(int idcomentarios) {
		this.idcomentarios = idcomentarios;
	}

	public Alumnos getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumnos alumnos) {
		this.alumnos = alumnos;
	}

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Comentarios [idcomentarios=" + idcomentarios + ", alumnos=" + alumnos + ", curso=" + curso
				+ ", comentario=" + comentario + "]";
	}
	
}
