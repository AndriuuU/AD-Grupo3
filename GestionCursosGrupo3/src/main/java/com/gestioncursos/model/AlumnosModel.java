package com.gestioncursos.model;

import java.util.Arrays;

import com.gestioncursos.entity.User;

public class AlumnosModel {

	private int idAlumno;
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private String password;
	
	private User usuario;
	
	private byte[] foto;

	public AlumnosModel() {
		super();
	}

	public AlumnosModel(int idAlumno, String nombre, String apellidos, String email, String password, User usuario,
			byte[] foto) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.usuario = usuario;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "AlumnosModel [idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", password=" + password + ", usuario=" + usuario + ", foto=" + Arrays.toString(foto) + "]";
	}

	

	

	
	
	

	
}
