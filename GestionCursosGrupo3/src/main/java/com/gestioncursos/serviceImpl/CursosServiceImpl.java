package com.gestioncursos.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestioncursos.entity.Cursos;
import com.gestioncursos.model.CursosModel;
import com.gestioncursos.repository.CursosRepository;
import com.gestioncursos.service.CursosService;
@Service("cursosService")
public class CursosServiceImpl implements CursosService {

	@Autowired
	@Qualifier("cursosRepository")
	private CursosRepository cursoRepository;
	
	@Override
	public List<CursosModel> listAllCursos() {
		return cursoRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public Cursos addCurso(CursosModel cursoModel) {
		Cursos curso = transform(cursoModel);
		return cursoRepository.save(curso);
	}

	@Override
	public int removeCurso(int id) {
		cursoRepository.deleteById(id);
		return 0;
	}

	@Override
	public Cursos updateCurso(CursosModel cursoModel) {
		Cursos curso = transform(cursoModel);
		return cursoRepository.save(curso);
	}

	@Override
	public CursosModel findCurso(int id) {
		return transform(cursoRepository.findById(id).orElse(null));
	}
	
	@Override
	public Cursos transform(CursosModel cursoModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cursoModel, Cursos.class);
	}

	@Override
	public CursosModel transform(Cursos curso) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(curso, CursosModel.class);
	}
	
	@Override
	public List<CursosModel> listAllCursosProfesor(long id) {
		List<CursosModel> cursos=cursoRepository.findAll().stream().map(c->transform(c)).collect(Collectors.toList());
		List<CursosModel> cursosProfesorId=new ArrayList<>();
		for(CursosModel c:cursos) {
			if(c.getIdProfesor()==id) {
				cursosProfesorId.add(c);
			}
		}
		return cursosProfesorId;
	}

	@Override
	public List<CursosModel> listAllCursosByNivelAsc() {
		return cursoRepository.findByOrderByNivelAsc().stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}
	
	@Override
	public List<CursosModel> listAllCursosByNivelDesc() {
		return cursoRepository.findByOrderByNivelDesc().stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public List<CursosModel> ListAllCursosDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}


}
