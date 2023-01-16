package com.gestioncursos.model;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import com.gestioncursos.entity.User;

public class AdministradoresModel {

	private int idadministradores;
	
	private User usuario;
	
	@Column(name = "password", nullable = false)
	@Size(max = 100)
	private User password;

	public AdministradoresModel() {
		super();
	}

	public AdministradoresModel(int idadministradores, User usuario, User password) {
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
