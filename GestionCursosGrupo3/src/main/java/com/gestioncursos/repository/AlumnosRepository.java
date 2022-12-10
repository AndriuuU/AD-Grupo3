package com.gestioncursos.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestioncursos.entity.Alumnos;
import com.gestioncursos.entity.User;

@Repository("alumnoRepository")
public interface AlumnosRepository extends JpaRepository<Alumnos, Serializable> {

	public abstract Alumnos findByEmail(String email);
	
}
