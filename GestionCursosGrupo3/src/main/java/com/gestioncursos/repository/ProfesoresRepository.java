package com.gestioncursos.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestioncursos.entity.Profesores;

@Repository("profesorRepository")
public interface ProfesoresRepository extends JpaRepository<Profesores, Serializable> {
	public abstract Profesores findByidProfesor(int id);
}
