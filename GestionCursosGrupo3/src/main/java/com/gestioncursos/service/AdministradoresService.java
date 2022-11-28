package com.gestioncursos.service;

import java.util.List;

import com.gestioncursos.entity.Administradores;
import com.gestioncursos.model.AdministradoresModel;

public interface AdministradoresService {
	
	public abstract List<AdministradoresModel> listAllAdministradores();
	
	public abstract Administradores addAdministrador(AdministradoresModel administradoresModel);

	public abstract int removeAdministrador(int id);
	
	public abstract Administradores updateAdministrador(AdministradoresModel administradoresModel);
	
	public abstract Administradores transform(AdministradoresModel administradoresModel);
	
	public abstract AdministradoresModel transform(Administradores administradores);
	
	public abstract AdministradoresModel findAdministrador(int id);
	
}
