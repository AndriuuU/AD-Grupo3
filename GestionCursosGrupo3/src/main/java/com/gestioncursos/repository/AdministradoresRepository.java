package com.gestioncursos.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestioncursos.entity.Administradores;

@Repository("administradoresRepository")
public interface AdministradoresRepository extends JpaRepository<Administradores, Serializable> {

//	public abstract Administradores findByIdadministradores(int id);
	
}
