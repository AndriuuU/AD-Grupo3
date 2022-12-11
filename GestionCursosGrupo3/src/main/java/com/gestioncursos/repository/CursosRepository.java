package com.gestioncursos.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestioncursos.entity.Cursos;

@Repository("cursosRepository")
public interface CursosRepository extends JpaRepository<Cursos, Serializable> {
	
	public abstract Cursos findByIdCursos(int id);
	
	public abstract Cursos findByFechaInicioBetween(Date fechaInicio, Date fechaFin);
	
	public abstract List<Cursos> findByNombreOrderByNivel(String nombre);

}
