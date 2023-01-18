package com.gestioncursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestioncursos.constantes.Constantes;
import com.gestioncursos.model.MatriculaModel;	
import com.gestioncursos.repository.MatriculaRepository;
import com.gestioncursos.service.MatriculaService;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {
	
	@Autowired
	@Qualifier("matriculaService")
	private MatriculaService matriculaService;
	
	
	@Autowired
	@Qualifier("matriculaRepository")
	private MatriculaRepository matriculaRepository;
	
	
	@PostMapping("/calificar/{idCurso}/{idAlumno}")
	public String calificar(@PathVariable(name = "idCurso", required = true) Integer idCurso,@PathVariable(name = "idAlumno", required = true) 
	Integer idAlumno,@ModelAttribute("valoracion") Float valoracion, RedirectAttributes flash) {
		MatriculaModel m=matriculaService.findMatriculaCurso(idCurso,idAlumno);
		m.setValoracion(valoracion);	
		matriculaService.updateMatricula(m);
		flash.addFlashAttribute("success", "Nota modificada con éxito");
		return "redirect:/profesores/listCursos/califica/"+idCurso;
	}

}
