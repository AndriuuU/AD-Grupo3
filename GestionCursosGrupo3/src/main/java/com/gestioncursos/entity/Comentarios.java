package com.gestioncursos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
public class Comentarios {

	@Id
	@Column(name="idcomentarios")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcomentarios;
	
	@ManyToOne
	@JoinColumn(name="idAlumno")
	private Alumnos idalumno;
	
	@ManyToOne
	@JoinColumn(name="idCurso")
	private Cursos idcurso;
	
	@Column(name="comentario", length=45)
	private String comentario;

	public Comentarios() {
		super();
	}

	public Comentarios(int idcomentarios, Alumnos idalumno, Cursos idcurso, String comentario) {
		super();
		this.idcomentarios = idcomentarios;
		this.idalumno = idalumno;
		this.idcurso = idcurso;
		this.comentario = comentario;
	}

	public int getIdcomentarios() {
		return idcomentarios;
	}

	public void setIdcomentarios(int idcomentarios) {
		this.idcomentarios = idcomentarios;
	}

	public Alumnos getAlumnos() {
		return idalumno;
	}

	public void setAlumnos(Alumnos idalumno) {
		this.idalumno = idalumno;
	}

	public Cursos getCurso() {
		return idcurso;
	}

	public void setCurso(Cursos idcurso) {
		this.idcurso = idcurso;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Comentarios [idcomentarios=" + idcomentarios + ", idalumno=" + idalumno + ", idcurso=" + idcurso
				+ ", comentario=" + comentario + "]";
	}
	
}
