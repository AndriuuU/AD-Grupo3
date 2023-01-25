package com.gestioncursos.model;

public class MatriculaModel {

	private int idMatricula;
	
	private float valoracion;
	
	private int idAlumno;
	
	private int idCurso;
	

	public MatriculaModel() {
		super();
	}

	public MatriculaModel(int idMatricula, float valoracion, int idAlumno, int idCurso) {
		super();
		this.idMatricula = idMatricula;
		this.valoracion = valoracion;
		this.idAlumno = idAlumno;
		this.idCurso = idCurso;
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

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	


	@Override
	public String toString() {
		return "MatriculaModel [idMatricula=" + idMatricula + ", valoracion=" + valoracion + ", idAlumno=" + idAlumno
				+ ", idCurso=" + idCurso + "]";
	}

	
	
	

	
	
	

}
