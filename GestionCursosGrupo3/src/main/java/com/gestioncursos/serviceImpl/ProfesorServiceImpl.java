package com.gestioncursos.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestioncursos.entity.Profesores;
import com.gestioncursos.model.ProfesoresModel;
import com.gestioncursos.repository.ProfesoresRepository;
import com.gestioncursos.service.ProfesoresService;
@Service("profesorService")
public class ProfesorServiceImpl implements ProfesoresService{
	
	@Autowired
	@Qualifier("profesorRepository")
	private ProfesoresRepository profesorRepository;

	@Override
	public List<ProfesoresModel> listAllProfesores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profesores addProfesor(ProfesoresModel ProfesoresModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeProfesor(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Profesores updateProfesor(ProfesoresModel ProfesoresModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profesores transform(ProfesoresModel ProfesoresModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfesoresModel transform(Profesores Profesores) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfesoresModel findProfesor(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
