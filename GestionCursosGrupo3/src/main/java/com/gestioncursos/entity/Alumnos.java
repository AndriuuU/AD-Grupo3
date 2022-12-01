package com.gestioncursos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Alumnos extends User {

	@Id
	@Column(name="idalumnos")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idalumnos;
	
	@Column(name="nombre", length=45)
	private String nombre;
	
	@Column(name="apellidos", length=45)
	private String apellidos;
	
//	private String gmail;
//	
//	private User password;
	
	@Column(name="foto", length=45, nullable=true)
	private String foto;

	public Alumnos() {
		super();
	}

	public Alumnos(int idalumnos, String nombre, String apellidos, String foto) {
		super();
		this.idalumnos = idalumnos;
		this.nombre = nombre;
		this.apellidos = apellidos;
//		this.gmail = gmail;
//		this.password = password;
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

//	public String getGmail() {
//		return gmail;
//	}
//
//	public void setGmail(String gmail) {
//		this.gmail = gmail;
//	}
//	public User getPassword() {
//		return password;
//	}
//
//	public void setPassword(User password) {
//		this.password = password;
//	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
}
