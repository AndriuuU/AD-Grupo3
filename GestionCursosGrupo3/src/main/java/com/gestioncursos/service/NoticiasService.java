package com.gestioncursos.service;

import java.util.List;

import com.gestioncursos.entity.Noticias;
import com.gestioncursos.model.NoticiasModel;

public interface NoticiasService {
	
	public abstract List<NoticiasModel> listAllNoticias();
	
	public abstract Noticias addNoticia(NoticiasModel noticiasModel);

	public abstract int removeNoticia(int id);
	
	public abstract Noticias updateNoticia(NoticiasModel noticiasModel);
	
	public abstract Noticias transform(NoticiasModel noticiasModel);
	
	public abstract NoticiasModel transform(Noticias noticias);
	
	public abstract NoticiasModel findNoticia(int id);
}
