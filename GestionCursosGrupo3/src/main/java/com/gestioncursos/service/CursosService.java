package com.gestioncursos.service;

import java.util.List;

import com.gestioncursos.entity.Cursos;
import com.gestioncursos.model.CursosModel;
import com.gestioncursos.model.MatriculaModel;

public interface CursosService {

	public abstract List<CursosModel> listAllCursos();
	
	public abstract Cursos addCurso(CursosModel cursosModel);

	public abstract int removeCurso(int id);
	
	public abstract Cursos updateCurso(CursosModel cursosModel);
	
	public abstract Cursos transform(CursosModel cursosModel);
	
	public abstract CursosModel transform(Cursos cursos);
	
	public abstract CursosModel findCurso(int id);
	
	public abstract List<CursosModel> listAllCursosProfesor(long id);
//	public abstract List<Alumnos> listAllAlumnos(CursosModel cursosModel);
	
	public abstract List<CursosModel> listAllCursosByNivelAsc();
	
	public abstract List<CursosModel> listAllCursosByNivelDesc();
	
	public abstract List<CursosModel> ListAllCursosMatriculados(String username);

	public abstract List<CursosModel> listCursosAlumno(int idAlumno);

	public abstract List<MatriculaModel> listMatriculasAcabadas();

	

	
}
