package com.gestioncursos.model;


public class NoticiasModel {

	private int idNoticias;
	
	private String titulo;
	
	private String descripcion;
	
	private String imagen;
	
	private long idAdmin;

	public NoticiasModel() {
		super();
	}

	public NoticiasModel(int idNoticias, String titulo, String descripcion, String imagen, long idAdmin) {
		super();
		this.idNoticias = idNoticias;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.idAdmin = idAdmin;
	}

	public int getIdNoticias() {
		return idNoticias;
	}

	public void setIdNoticias(int idNoticias) {
		this.idNoticias = idNoticias;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
	}

	@Override
	public String toString() {
		return "NoticiasModel [idNoticias=" + idNoticias + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", idAdmin=" + idAdmin + "]";
	}

	
	

	
}
