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
@Table(name="administradores")
@Inheritance(strategy = InheritanceType.JOINED)
public class Administradores extends User {

	@Id
	@Column(name="idadministradores")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idadministradores;
	
//	@OneToOne(mappedBy="gmail")
//	private User gmail;
//	
//	@OneToOne(mappedBy="password")
//	private User password;

	public Administradores() {
		super();
	}

	public Administradores(int idadministradores) {
		super();
		this.idadministradores = idadministradores;
//		this.gmail = gmail;
//		this.password = password;
	}

	public int getIdadministradores() {
		return idadministradores;
	}

	public void setIdadministradores(int idadministradores) {
		this.idadministradores = idadministradores;
	}

//	public User getGmail() {
//		return gmail;
//	}
//
//	public void setGmail(User usuario) {
//		this.gmail = usuario;
//	}
//
//	public User getPassword() {
//		return password;
//	}
//
//	public void setPassword(User password) {
//		this.password = password;
//	}
//
//	@Override
//	public String toString() {
//		return "Administradores [idadministradores=" + idadministradores + ", gmail=" + gmail + ", password="
//				+ password + "]";
//	}
	
	
}
