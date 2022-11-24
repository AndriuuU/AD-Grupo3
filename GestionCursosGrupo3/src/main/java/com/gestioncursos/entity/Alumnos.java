package com.gestioncursos.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alumnos {

	@Id
	@GeneratedValue
	private int idalumnos;
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private User usuario;
	
	private User password;
	
	private byte[] foto;

	public Alumnos() {
		super();
	}

	public Alumnos(int idalumnos, String nombre, String apellidos, String email, User usuario, User password,
			byte[] foto) {
		super();
		this.idalumnos = idalumnos;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.foto = foto;
	}

	public int getidalumnos() {
		return idalumnos;
	}

	public void setidalumnos(int idalumnos) {
		this.idalumnos = idalumnos;
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
		return "Alumnos [idalumnos=" + idalumnos + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", usuario=" + usuario + ", password=" + password + ", foto=" + Arrays.toString(foto) + "]";
	}
	
	
}
