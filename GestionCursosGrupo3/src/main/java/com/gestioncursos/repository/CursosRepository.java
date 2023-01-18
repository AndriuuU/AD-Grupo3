package com.gestioncursos.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestioncursos.entity.Cursos;

@Repository("cursosRepository")
public interface CursosRepository extends JpaRepository<Cursos, Serializable> {
	
	public abstract Cursos findByIdCurso(int id);
	
	public abstract Cursos findByFechaInicioBetween(Date fechaInicio, Date fechaFin);
	
	public abstract List<Cursos> findByNombreOrderByNivel(String nombre);
	
	public abstract List<Cursos> findByOrderByNivelAsc();
	
	public abstract List<Cursos> findByOrderByNivelDesc();
	
	@Query("select curso from Cursos curso inner join curso.matriculaList matricula where matricula.alumno.id = ?#{[0]}")
	public abstract List<Cursos> findCursoByQuery(Integer id);

//	https://spring.io/blog/2014/07/15/spel-support-in-spring-data-jpa-query-definitions

}
