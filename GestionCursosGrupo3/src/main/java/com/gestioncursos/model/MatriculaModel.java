package com.gestioncursos.model;

public class MatriculaModel {

	private int idmatricula;

	public MatriculaModel() {
		super();
	}

	public MatriculaModel(int idmatricula) {
		super();
		this.idmatricula = idmatricula;
	}

	public int getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}

	@Override
	public String toString() {
		return "MatriculaModel [idmatricula=" + idmatricula + "]";
	}

}
