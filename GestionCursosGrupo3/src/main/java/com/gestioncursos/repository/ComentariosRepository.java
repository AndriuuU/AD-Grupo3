package com.gestioncursos.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestioncursos.entity.Comentarios;

@Repository("comentariosRepository")
public interface ComentariosRepository extends JpaRepository<Comentarios, Serializable> {
//	public abstract Comentarios findById(int id);
	
}
