package com.gestioncursos.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Alumnos {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAlumno;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private String foto;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="alumno")
	private List<Matricula> matriculaList;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="alumno")
	private List<Comentarios> comentarioList;
	
	public Alumnos() {
		super();
	}
	public Alumnos(int idAlumno, String nombre, String apellidos, String email, String password,
			String foto) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
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
		return "Alumnos [idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", foto=" + foto + "]";
	}
}
