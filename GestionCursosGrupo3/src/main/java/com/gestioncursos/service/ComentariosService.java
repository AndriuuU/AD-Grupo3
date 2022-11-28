package com.gestioncursos.service;

import java.util.List;

import com.gestioncursos.entity.Comentarios;
import com.gestioncursos.model.ComentariosModel;


public interface ComentariosService {

	public abstract List<ComentariosModel> listAllComentarios();
	
	public abstract Comentarios addComentario(ComentariosModel comentariosModel);

	public abstract int removeComentario(int id);
	
	public abstract Comentarios updateComentario(ComentariosModel comentariosModel);
	
	public abstract Comentarios transform(ComentariosModel comentariosModel);
	
	public abstract ComentariosModel transform(Comentarios comentarios);
	
	public abstract ComentariosModel findComentario(int id);
}
