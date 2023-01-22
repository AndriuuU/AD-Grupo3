package com.gestioncursos.serviceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestioncursos.entity.Profesores;
import com.gestioncursos.model.CursosModel;
import com.gestioncursos.model.MatriculaModel;
import com.gestioncursos.model.ProfesoresModel;
import com.gestioncursos.repository.ProfesoresRepository;
import com.gestioncursos.service.MatriculaService;
import com.gestioncursos.service.ProfesoresService;
@Service("profesoresService")
public class ProfesorServiceImpl implements ProfesoresService{
	
	@Autowired
	@Qualifier("profesorRepository")
	private ProfesoresRepository profesorRepository;
	
	@Autowired
	@Qualifier("userService")
	private UsersService userService;
	
	
	@Autowired
	@Qualifier("matriculaService")
	private MatriculaService matriculaService;
	

	@Override
	public List<ProfesoresModel> listAllProfesores() {
		return profesorRepository.findAll().stream().map(c -> transform(c)).collect(Collectors.toList());
	}

	@Override
	public Profesores addProfesor(ProfesoresModel profesorModel) {
		profesorModel.setPassword(userService.passwordEncoder().encode(profesorModel.getPassword()));
		return profesorRepository.save(transform(profesorModel));
	}

	@Override
	public int removeProfesor(int id) {
		profesorRepository.deleteById(id);
		return 0;
	}

	@Override
	public Profesores updateProfesor(ProfesoresModel profesorModel) {
		return profesorRepository.save(transform(profesorModel));
	}
	
	@Override
	public Profesores transform(ProfesoresModel courseModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(courseModel, Profesores.class);
	}

	@Override
	public ProfesoresModel transform(Profesores course) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(course, ProfesoresModel.class);
	}

	@Override
	public ProfesoresModel findProfesor(String email) {
		return transform(profesorRepository.findByEmail(email));
	}
	@Override
	public ProfesoresModel findProfesor(int id) {
		return transform(profesorRepository.findById(id).orElse(null));
	}
	
	
	
	


}
