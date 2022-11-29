package com.gestioncursos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Administradores {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idadministradores;
	@OneToOne(mappedBy="gmail")
	private User gmail;
	
	@OneToOne(mappedBy="password")
	private User password;

	public Administradores() {
		super();
	}

	public Administradores(int idadministradores, User gmail, User password) {
		super();
		this.idadministradores = idadministradores;
		this.gmail = gmail;
		this.password = password;
	}

	public int getIdadministradores() {
		return idadministradores;
	}

	public void setIdadministradores(int idadministradores) {
		this.idadministradores = idadministradores;
	}

	public User getGmail() {
		return gmail;
	}

	public void setGmail(User usuario) {
		this.gmail = usuario;
	}

	public User getPassword() {
		return password;
	}

	public void setPassword(User password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administradores [idadministradores=" + idadministradores + ", gmail=" + gmail + ", password="
				+ password + "]";
	}
	
	
}
