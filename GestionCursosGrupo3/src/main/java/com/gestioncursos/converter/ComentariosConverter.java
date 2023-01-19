package com.gestioncursos.converter;

import org.springframework.stereotype.Component;

import com.gestioncursos.entity.Comentarios;
import com.gestioncursos.model.ComentariosModel;

@Component("comentariosConverter")
public class ComentariosConverter {

	
	//Entity-To-Model
	
	public ComentariosModel entity2model(Comentarios comentarios) {
		ComentariosModel comentariosModel = new ComentariosModel();
		comentariosModel.setIdcomentarios(comentarios.getIdComentarios());
		comentariosModel.setAlumno(comentarios.getAlumno());
		comentariosModel.setComentario(comentarios.getComentario());
		comentariosModel.setCurso(comentarios.getCurso());
		return comentariosModel;
	}
	
	
	// Model-To-Entity
	
	public Comentarios model2entity(ComentariosModel comentariosModel) {
		Comentarios comentarios = new Comentarios();
		comentarios.setIdComentarios(comentariosModel.getIdcomentarios());
		comentarios.setAlumno(comentariosModel.getAlumno());
		comentarios.setComentario(comentariosModel.getComentario());
		comentarios.setCurso(comentariosModel.getCurso());
		return comentarios;
	}
	
}
