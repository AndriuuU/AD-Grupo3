package com.gestioncursos.model;


import com.gestioncursos.entity.User;

public class ProfesoresModel {

	private int idProfesor;
	
	private String nombre;
	
	private String apellidos;
	
	private String email;

	private String password;
	
	private User usuario;
	
	public ProfesoresModel() {
		super();
	}

	public ProfesoresModel(int idProfesor, String nombre, String apellidos, String email, String password,
			User usuario) {
		super();
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.usuario = usuario;
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

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "ProfesoresModel [idProfesor=" + idProfesor + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email + ", password=" + password + ", usuario=" + usuario + "]";
	}

	
	
	
}
