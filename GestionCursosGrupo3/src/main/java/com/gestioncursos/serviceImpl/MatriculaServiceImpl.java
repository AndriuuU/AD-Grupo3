package com.gestioncursos.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestioncursos.entity.Matricula;
import com.gestioncursos.model.MatriculaModel;
import com.gestioncursos.repository.MatriculaRepository;
import com.gestioncursos.service.MatriculaService;

@Service("matriculaService")
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	@Qualifier("matriculaRepository")
	private MatriculaRepository matriculaRepository;
	
	
	@Override
	public List<MatriculaModel> listAllMatriculas() {
		return matriculaRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public Matricula addMatricula(MatriculaModel matriculaModel) {
		Matricula matricula = transform(matriculaModel);
		return matriculaRepository.save(matricula);
	}

	@Override
	public int removeMatricula(int id) {
		matriculaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Matricula updateMatricula(MatriculaModel matriculaModel) {
		Matricula matricula = transform(matriculaModel);
		return matriculaRepository.save(matricula);
	}

	@Override
	public Matricula transform(MatriculaModel matriculaModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(matriculaModel, Matricula.class);
	}

	@Override
	public MatriculaModel transform(Matricula matricula) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(matricula, MatriculaModel.class);
	}

	@Override
	public MatriculaModel findMatricula(int id) {
		return transform(matriculaRepository.findById(id).orElse(null));
	}
	
	@Override
	public List<MatriculaModel> listMatriculasCurso(int idCurso) {		
		List<MatriculaModel> matriculas = matriculaRepository.findAll().stream()
				.map(c->transform(c)).collect(Collectors.toList());
		List<MatriculaModel> listMatriculas = new ArrayList<>();
		for(MatriculaModel m: matriculas) {
			if(m.getIdCurso()==idCurso) {
				listMatriculas.add(m);
			}
		}
		return listMatriculas;
	}


}
