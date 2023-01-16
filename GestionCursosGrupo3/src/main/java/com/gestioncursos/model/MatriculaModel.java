package com.gestioncursos.model;

public class MatriculaModel {

	private int idMatricula;
	
	private float valoracion;
	
	private int alumno_id;
	
	private int curso_id;

	public MatriculaModel() {
		super();
	}

	public MatriculaModel(int idmatricula) {
		super();
		this.idMatricula = idmatricula;
	}

	public MatriculaModel(int idMatricula, float valoracion, int alumno_id, int curso_id) {
		super();
		this.idMatricula = idMatricula;
		this.valoracion = valoracion;
		this.alumno_id = alumno_id;
		this.curso_id = curso_id;
	}

	public int getIdmatricula() {
		return idMatricula;
	}

	public void setIdmatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}
	

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public int getAlumno_id() {
		return alumno_id;
	}

	public void setAlumno_id(int alumno_id) {
		this.alumno_id = alumno_id;
	}

	public int getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}

	@Override
	public String toString() {
		return "MatriculaModel [idMatricula=" + idMatricula + ", valoracion=" + valoracion + ", alumno_id=" + alumno_id
				+ ", curso_id=" + curso_id + "]";
	}

	

}
