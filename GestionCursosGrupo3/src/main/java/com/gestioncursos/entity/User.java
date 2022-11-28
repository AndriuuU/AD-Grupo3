package com.gestioncursos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="gmail", unique=true, nullable=false)
	private String gmail;
	
	@Column(name="password", nullable=false)
	@Size(max=100)
	private String password;
	
	private boolean enabled;
	
	private String role;
	
	public User() {
		super();
	}

	public User(long id, String gmail, @Size(max = 100) String password, boolean enabled, String role) {
		super();
		this.id = id;
		this.gmail = gmail;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String username) {
		this.gmail = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", gmail=" + gmail + ", password=" + password + ", enabled=" + enabled
				+ ", role=" + role + "]";
	}
	
}
