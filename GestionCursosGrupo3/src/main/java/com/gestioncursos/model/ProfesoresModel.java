package com.gestioncursos.model;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import com.gestioncursos.entity.User;

public class ProfesoresModel {

	private int idProfesor;
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private User usuario;
	
	@Column(name = "password", nullable = false)
	@Size(max = 100)
	private User password;

	public ProfesoresModel() {
		super();
	}

	public ProfesoresModel(int idProfesor, String nombre, String apellidos, String email, User usuario, User password) {
		super();
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
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

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public User getPassword() {
		return password;
	}

	public void setPassword(User password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ProfesoresModel [idProfesor=" + idProfesor + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email + ", usuario=" + usuario + ", password=" + password + "]";
	}

	
	
}
