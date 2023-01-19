package com.gestioncursos.model;



public class ComentariosModel {

	private int idComentarios;
	
	private String comentario;
	
	private int idCurso;
	
	private int idAlumno;

	public ComentariosModel() {
		super();
	}

	public ComentariosModel(int idComentarios, String comentario, int idCurso, int idAlumno) {
		super();
		this.idComentarios = idComentarios;
		this.comentario = comentario;
		this.idCurso = idCurso;
		this.idAlumno = idAlumno;
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

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	@Override
	public String toString() {
		return "ComentariosModel [idComentarios=" + idComentarios + ", comentario=" + comentario + ", idCurso="
				+ idCurso + ", idAlumno=" + idAlumno + "]";
	}
	
	

	
	

}
