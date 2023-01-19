package com.gestioncursos.model;


import com.gestioncursos.entity.Alumnos;
import com.gestioncursos.entity.Cursos;

public class ComentariosModel {

	private int idcomentarios;
	
	private String comentario;
	
	private Cursos curso;
	
	private Alumnos alumno;

	public ComentariosModel() {
		super();
	}

	public ComentariosModel(int idcomentarios, String comentario, Cursos curso, Alumnos alumno) {
		super();
		this.idcomentarios = idcomentarios;
		this.comentario = comentario;
		this.curso = curso;
		this.alumno = alumno;
	}

	public int getIdcomentarios() {
		return idcomentarios;
	}

	public void setIdcomentarios(int idcomentarios) {
		this.idcomentarios = idcomentarios;
	}
	
	public Cursos getCurso() {
		return this.curso;
	}
	
	public void setCurso(Cursos curso) {
		this.curso=curso;
	}
	
	public Alumnos getAlumno() {
		return this.alumno;
	}
	
	public void setAlumno(Alumnos alumno) {
		this.alumno=alumno;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	@Override
	public String toString() {
		return "ComentariosModel [idcomentarios=" + idcomentarios + ", comentario=" + comentario + "]";
	}

}
