package com.gestioncursos.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestioncursos.entity.Matricula;

@Repository("matriculaRepository")
public interface MatriculaRepository extends JpaRepository<Matricula, Serializable> {

//	public abstract Matricula findByIdmatricula(int id);
	
}
