package com.gestioncursos.model;

public class AccionesModels {

	private String nombre;
	
	private float valoracion;
	
	

	public AccionesModels() {
		super();
	}



	public AccionesModels(String nombre, float valoracion) {
		super();
		this.nombre = nombre;
		this.valoracion = valoracion;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public float getValoracion() {
		return valoracion;
	}



	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}



	@Override
	public String toString() {
		return "AccionesModels [nombre=" + nombre + ", valoracion=" + valoracion + "]";
	}
	
	
	
	
	
	
	
	
	
}
