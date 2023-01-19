package com.gestioncursos.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestioncursos.entity.Comentarios;
import com.gestioncursos.model.ComentariosModel;
import com.gestioncursos.repository.ComentariosRepository;
import com.gestioncursos.service.ComentariosService;

@Service("comentariosService")
public class ComentariosServiceImpl implements ComentariosService{
	
	@Autowired
	@Qualifier("comentariosRepository")
	private ComentariosRepository comentariosRepository;
	
	@Override
	public List<ComentariosModel> listAllComentarios() {
		// TODO Auto-generated method stub
		return comentariosRepository.findAll().stream().map(x->transform(x)).collect(Collectors.toList());
	}

	@Override
	public Comentarios addComentario(ComentariosModel comentariosModel) {
		return comentariosRepository.save(transform(comentariosModel));
		
	}

	@Override
	public int removeComentario(int id) {
		comentariosRepository.deleteById(id);
		return 0;
	}

	@Override
	public Comentarios updateComentario(ComentariosModel comentariosModel) {
		// TODO Auto-generated method stub
		return comentariosRepository.save(transform(comentariosModel));
	}

	@Override
	public Comentarios transform(ComentariosModel comentariosModel) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(comentariosModel, Comentarios.class);
	}

	@Override
	public ComentariosModel transform(Comentarios comentarios) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(comentarios, ComentariosModel.class);
	}

	@Override
	public ComentariosModel findComentario(int id) {
		// TODO Auto-generated method stub
		return transform(comentariosRepository.findById(id).orElse(null));
	}
	
	
}
