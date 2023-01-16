package com.gestioncursos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestioncursos.entity.Profesores;
import com.gestioncursos.model.CursosModel;
import com.gestioncursos.model.MatriculaModel;
import com.gestioncursos.model.ProfesoresModel;


public interface ProfesoresService {

	public abstract List<ProfesoresModel> listAllProfesores();
	
	public abstract Profesores addProfesor(ProfesoresModel ProfesoresModel);

	public abstract int removeProfesor(int id);
	
	public abstract Profesores updateProfesor(ProfesoresModel ProfesoresModel);
	
	public abstract Profesores transform(ProfesoresModel ProfesoresModel);
	
	public abstract ProfesoresModel transform(Profesores Profesores);
	
	public abstract ProfesoresModel findProfesor(int id);

	public abstract ProfesoresModel findProfesor(String email);

}
