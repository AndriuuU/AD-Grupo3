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
@Table(name="profesores")
@Inheritance(strategy = InheritanceType.JOINED)
public class Profesores extends User {

	@Id
	@Column(name="idprofesores")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idprofesores;
	
	@Column(name="nombre", length=45)
	private String nombre;
	
	@Column(name="apellidos", length=45)
	private String apellidos;
	
//	private String gmail;
//	
//	private User password;

	public Profesores() {
		super();
	}

	public Profesores(int idprofesores, String nombre, String apellidos) {
		super();
		this.idprofesores = idprofesores;
		this.nombre = nombre;
		this.apellidos = apellidos;
//		this.gmail = gmail;
//		this.password = password;
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

//	public String getGmail() {
//		return gmail;
//	}
//
//	public void setGmail(String gmail) {
//		this.gmail = gmail;
//	}
//
//	public User getPassword() {
//		return password;
//	}
//
//	public void setPassword(User password) {
//		this.password = password;
//	}

}
