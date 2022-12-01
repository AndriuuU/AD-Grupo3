package com.gestioncursos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profesores")
public class Profesores {

	@Id
	@Column(name="idprofesores")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idprofesores;
	
	@Column(name="nombre", length=45)
	private String nombre;
	
	@Column(name="apellidos", length=45)
	private String apellidos;
	
	private String email;
	
	private User usuario;
	
	private User password;

	public Profesores() {
		super();
	}

	public Profesores(int idprofesores, String nombre, String apellidos, String email, User usuario, User password) {
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
