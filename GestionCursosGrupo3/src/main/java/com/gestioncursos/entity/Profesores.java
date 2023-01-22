package com.gestioncursos.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Profesores {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProfesor;
	private String nombre;
	private String apellidos;
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	private String password;
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="profesor")
	private List<Cursos> cursosList;
	
	@OneToOne
	@JoinColumn(name="idUsuario", referencedColumnName="id")
	private User usuario;
	
	public Profesores() {
		super();
	}

	public Profesores(int idProfesor, String nombre, String apellidos, String email, String password,
			List<Cursos> cursosList) {
		super();
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.cursosList = cursosList;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Cursos> getCursosList() {
		return cursosList;
	}

	public void setCursosList(List<Cursos> cursosList) {
		this.cursosList = cursosList;
	}

	@Override
	public String toString() {
		return "Profesores [idProfesor=" + idProfesor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", password=" + password + ", cursosList=" + cursosList + "]";
	}
	
	
	
	
}
