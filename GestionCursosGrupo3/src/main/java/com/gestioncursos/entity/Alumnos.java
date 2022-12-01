package com.gestioncursos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
public class Alumnos {

	@Id
	@Column(name="idalumnos")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idalumnos;
	
	@Column(name="nombre", length=45)
	private String nombre;
	
	@Column(name="apellidos", length=45)
	private String apellidos;
	
	private String email;
	
	private User usuario;
	
	private User password;
	
	@Column(name="foto", length=45, nullable=true)
	private String foto;

	public Alumnos() {
		super();
	}

	public Alumnos(int idalumnos, String nombre, String apellidos, String email, User usuario, User password,
			String foto) {
		super();
		this.idalumnos = idalumnos;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.foto = foto;
	}

	public int getIdalumnos() {
		return idalumnos;
	}

	public void setIdalumnos(int idalumnos) {
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Alumnos [idalumnos=" + idalumnos + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", usuario=" + usuario + ", password=" + password + ", foto=" + foto + "]";
	}

	
}
