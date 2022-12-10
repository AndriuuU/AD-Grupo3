package com.gestioncursos.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Profesores {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProfesor;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="profesor")
	private List<Cursos> cursosList;
	
	public Profesores() {
		super();
	}
	public Profesores(int id, String nombre, String apellidos, String email, String password) {
		super();
		this.idProfesor = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
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
		return "Profesor [idProfesor=" + idProfesor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", password=" + password + ", cursosList=" + cursosList + "]";
	}

	
	
}
