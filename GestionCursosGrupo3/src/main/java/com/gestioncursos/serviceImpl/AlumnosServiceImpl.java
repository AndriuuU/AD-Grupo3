package com.gestioncursos.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestioncursos.entity.Alumnos;
import com.gestioncursos.model.AlumnosModel;
import com.gestioncursos.repository.AlumnosRepository;
import com.gestioncursos.service.AlumnosService;


@Service("alumnoService")
public class AlumnosServiceImpl implements AlumnosService{
	
	@Autowired
	@Qualifier("alumnoRepository")
	private AlumnosRepository alumnoRepository;
	
	@Autowired
	@Qualifier("userService")
	private UsersService userService;

	@Override
	public List<AlumnosModel> listAllAlumnos() {
		return alumnoRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public Alumnos addAlumno(AlumnosModel alumnoModel) {
		alumnoModel.setPassword(userService.passwordEncoder().encode(alumnoModel.getPassword()));
		return alumnoRepository.save(transform(alumnoModel));
	}

	@Override
	public int removeAlumno(int id) {
		alumnoRepository.deleteById(id);
		return 0;
	}

	@Override
	public Alumnos updateAlumno(AlumnosModel alumnoModel) {
		return alumnoRepository.save(transform(alumnoModel));
	}

	@Override
	public Alumnos transform(AlumnosModel alumnoModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(alumnoModel, Alumnos.class);
	}

	@Override
	public AlumnosModel transform(Alumnos alumno) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(alumno, AlumnosModel.class);
	}

	@Override
	public AlumnosModel findAlumno(String email) {
		return transform(alumnoRepository.findByEmail(email));
	}
	
	@Override
	public AlumnosModel findAlumno(int id) {
		return transform(alumnoRepository.findById(id).orElse(null));
	}

	@Override
	public Alumnos findByEmail(String email) {
		return alumnoRepository.findByEmail(email);
	}

	



	

}
