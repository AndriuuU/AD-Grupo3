package com.gestioncursos.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gestioncursos.entity.Alumnos;
import com.gestioncursos.entity.Cursos;

public class ComentariosModel {

	private int idcomentarios;
	
	private String comentario;

	public ComentariosModel() {
		super();
	}

	public ComentariosModel(int idcomentarios, String comentario) {
		super();
		this.idcomentarios = idcomentarios;
		this.comentario = comentario;
	}

	public int getIdcomentarios() {
		return idcomentarios;
	}

	public void setIdcomentarios(int idcomentarios) {
		this.idcomentarios = idcomentarios;
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
