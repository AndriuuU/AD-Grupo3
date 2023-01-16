package com.gestioncursos.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import com.gestioncursos.entity.User;

public class AlumnosModel {

	private int idAlumno;
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private User usuario;
	
	@Column(name = "password", nullable = false)
	@Size(max = 100)
	private User password;
	
	private byte[] foto;

	public AlumnosModel() {
		super();
	}

	public AlumnosModel(int idAlumno, String nombre, String apellidos, String email, User usuario, User password,
			byte[] foto) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.foto = foto;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "AlumnosModel [idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", usuario=" + usuario + ", password=" + password + ", foto=" + Arrays.toString(foto) + "]";
	}

	
	
	

	
}
