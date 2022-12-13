package com.gestioncursos.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestioncursos.entity.Noticias;
import com.gestioncursos.model.NoticiasModel;
import com.gestioncursos.repository.NoticiasRepository;
import com.gestioncursos.service.NoticiasService;


@Service("noticiaService")
public class NoticiasServiceImpl implements NoticiasService {
	
	@Autowired
	@Qualifier("noticiaRepository")
	private NoticiasRepository noticiasRepository;

	@Override
	public List<NoticiasModel> listAllNoticias() {
		return noticiasRepository.findAll().stream().map(c -> transform(c)).collect(Collectors.toList());
	}

	@Override
	public Noticias addNoticia(NoticiasModel noticiasModel) {
		Noticias noticia = transform(noticiasModel);
		return noticiasRepository.save(noticia);
	}

	@Override
	public int removeNoticia(int id) {
		noticiasRepository.deleteById(id);
		return 0;
	}

	@Override
	public Noticias updateNoticia(NoticiasModel noticiasModel) {
		Noticias noticia = transform(noticiasModel);
		return noticiasRepository.save(noticia);
	}

	@Override
	public Noticias transform(NoticiasModel noticiasModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(noticiasModel, Noticias.class);
	}

	@Override
	public NoticiasModel transform(Noticias noticias) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(noticias, NoticiasModel.class);
	}

	@Override
	public NoticiasModel findNoticia(int id) {
		return transform(noticiasRepository.findById(id).orElse(null));
	}

}
