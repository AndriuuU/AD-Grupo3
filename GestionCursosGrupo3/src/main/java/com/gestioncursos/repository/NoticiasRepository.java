package com.gestioncursos.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestioncursos.entity.Noticias;

@Repository("noticiasRepository")
public interface NoticiasRepository extends JpaRepository<Noticias, Serializable> {
	
//	public abstract Noticias findByIdnoticias(int id);
	
}
