package com.gestioncursos.model;

import com.gestioncursos.entity.User;

public class ProfesoresModel {

	private int idprofesores;
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private User usuario;
	
	private User password;

	public ProfesoresModel() {
		super();
	}

	public ProfesoresModel(int idprofesores, String nombre, String apellidos, String email, User usuario, User password) {
		super();
		this.idprofesores = idprofesores;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
	}

	public int getIdprofesores() {
		return idprofesores;
	}

	public void setIdprofesores(int idprofesores) {
		this.idprofesores = idprofesores;
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
		return "Profesores [idprofesores=" + idprofesores + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email + ", usuario=" + usuario + ", password=" + password + "]";
	}
	
}