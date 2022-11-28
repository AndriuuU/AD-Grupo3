package com.gestioncursos.model;

public class UserModel {
	
	private long id;
	
	private String gmail;
	
	private String password;
	
	private boolean enabled;
	
	private String role;
	
	public UserModel() {
		super();
	}

	public UserModel(long id, String gmail, String password, boolean enabled, String role) {
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
