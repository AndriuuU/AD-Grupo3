package com.gestioncursos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Administradores {

	@Id
	@GeneratedValue
	private int idadministradores;
	
	private User usuario;
	
	private User password;

	public Administradores() {
		super();
	}

	public Administradores(int idadministradores, User usuario, User password) {
		super();
		this.idadministradores = idadministradores;
		this.usuario = usuario;
		this.password = password;
	}

	public int getIdadministradores() {
		return idadministradores;
	}

	public void setIdadministradores(int idadministradores) {
		this.idadministradores = idadministradores;
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
		return "Administradores [idadministradores=" + idadministradores + ", usuario=" + usuario + ", password="
				+ password + "]";
	}
	
	
}
