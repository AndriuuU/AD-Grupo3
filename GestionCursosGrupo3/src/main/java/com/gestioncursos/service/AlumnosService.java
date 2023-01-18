package com.gestioncursos.service;

import java.util.List;

import com.gestioncursos.entity.Alumnos;
import com.gestioncursos.model.AlumnosModel;


public interface AlumnosService {

	public abstract List<AlumnosModel> listAllAlumnos();
	
	public abstract Alumnos findByEmail(String email);
	
	public abstract Alumnos addAlumno(AlumnosModel alumnosModel);

	public abstract int removeAlumno(int id);
	
	public abstract Alumnos updateAlumno(AlumnosModel alumnosModel);
	
	public abstract Alumnos transform(AlumnosModel alumnosModel);
	
	public abstract AlumnosModel transform(Alumnos alumnos);
	
	public abstract AlumnosModel findAlumno(int id);
	
	public abstract AlumnosModel findAlumno(String email);

	
}
