	package com.gestioncursos.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestioncursos.entity.Matricula;
import com.gestioncursos.model.CursosModel;
import com.gestioncursos.model.MatriculaModel;
import com.gestioncursos.repository.MatriculaRepository;
import com.gestioncursos.service.AlumnosService;
import com.gestioncursos.service.CursosService;
import com.gestioncursos.service.MatriculaService;

@Service("matriculaService")
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	@Qualifier("matriculaRepository")
	private MatriculaRepository matriculaRepository;
	@Autowired
	@Qualifier("alumnoService")
	private AlumnosService alumnoService;

	
	
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
//		System.out.println(matricula);
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
	public MatriculaModel findMatriculaCurso(int idCurso,int idAlumno) {
	List<MatriculaModel> listMatriculas = listAllMatriculas();
	
	for(MatriculaModel m:listMatriculas) {
		if(m.getIdCurso()==idCurso && m.getIdAlumno()==idAlumno) {
			return m;
		}
		
	}
	return null;
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

	@Override
	public List<MatriculaModel> listMatriculasAlumno(int idAlumno) {
		List<MatriculaModel> matriculas = listAllMatriculas();
		List<MatriculaModel> matriculasAlumno = new ArrayList<>();
		
		for(MatriculaModel m :  matriculas) {
			if(m.getIdAlumno()==idAlumno) {
				matriculasAlumno.add(m);
			}
		}
		return matriculasAlumno;
	}

	
	

}
