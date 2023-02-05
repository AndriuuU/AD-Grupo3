package com.gestioncursos.model;

public class AccionesModels {

	private int idA;
	private String nombre;
	private String apellido;
	
	private float valoracion;
	
	

	public AccionesModels() {
		super();
	}



	public AccionesModels(int idA,String nombre, String apellido,float valoracion) {
		super();
		this.idA=idA;
		this.nombre = nombre;
		this.apellido=apellido;
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

	


	public int getIdA() {
		return idA;
	}



	public void setIdA(int idA) {
		this.idA = idA;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	@Override
	public String toString() {
		return "AccionesModels [nombre=" + nombre + ", valoracion=" + valoracion + "]";
	}
	
	
	
	
	
	
	
	
	
}
