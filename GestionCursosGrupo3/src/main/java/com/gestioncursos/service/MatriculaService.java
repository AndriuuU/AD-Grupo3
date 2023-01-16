package com.gestioncursos.service;

import java.util.List;

import com.gestioncursos.entity.Matricula;
import com.gestioncursos.model.MatriculaModel;

public interface MatriculaService {

	
	public abstract List<MatriculaModel> listAllMatriculas();
	
	public abstract Matricula addMatricula(MatriculaModel matriculaModel);

	public abstract int removeMatricula(int id);
		
	public abstract Matricula updateMatricula(MatriculaModel matriculaModel);
	
	public abstract Matricula transform(MatriculaModel matriculaModel);
	
	public abstract MatriculaModel transform(Matricula matricula);
	
	public abstract MatriculaModel findMatricula(int id);
	
	public abstract List<MatriculaModel> listMatriculasCurso(int idCurso);
}
