package com.gestioncursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.gestioncursos.constantes.Constantes;
import com.gestioncursos.entity.Alumnos;
import com.gestioncursos.model.ComentariosModel;
import com.gestioncursos.repository.ComentariosRepository;
import com.gestioncursos.repository.CursosRepository;
import com.gestioncursos.service.AlumnosService;
import com.gestioncursos.service.ComentariosService;
import com.gestioncursos.service.CursosService;



@Controller
@RequestMapping("/comentarios")
public class ComentariosController {

	@Autowired
	@Qualifier("comentariosService")
	private ComentariosService comentariosService;
	
	@Autowired
	@Qualifier("cursosService")
	private CursosService cursosService;
	
	@Autowired
	@Qualifier("comentariosRepository")
	private ComentariosRepository comentariosRepository;

	@Autowired
	@Qualifier("alumnoService")
	private AlumnosService alumnoService;
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')") NO BORRAR
	@GetMapping("/listComentarios/{idCurso}")
	public ModelAndView listComentarios(@PathVariable("idCurso") int idCurso) {
		ModelAndView mav = new ModelAndView(Constantes.COMMENTS_VIEW);
		mav.addObject("cursos", comentariosService.listAllComentarios().stream().filter(x->x.getCurso().getIdCurso()==idCurso));
		return mav;	
	}

	@PostMapping("/{idCurso}/addComentario")
	public String addComentario(@PathVariable("idCurso") Integer idCurso,@ModelAttribute("comentario") ComentariosModel comentariosModel, 
			RedirectAttributes flash) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userEmail = authentication.getName();
	    Alumnos alumno = alumnoService.findByEmail(userEmail);
		comentariosModel.setAlumno(alumno);
		comentariosModel.setCurso(cursosService.transform(cursosService.findCurso(idCurso)));
		comentariosService.addComentario(comentariosModel);
		flash.addFlashAttribute("success", "Comentario insertado con éxito");
		return "redirect:/comentario/listComentarios";
	}

	@GetMapping(value = { "/formComentario", "/formComentario/{id}" })
	public String formComentario(@PathVariable(name = "id", required = false) Integer id, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userEmail = authentication.getName();
	    int idAlumno = alumnoService.findByEmail(userEmail).getIdAlumno();
		if (id == null) {
			model.addAttribute("comentario", new ComentariosModel());
		}
		else {
			model.addAttribute("comentario", comentariosService.findComentario(id));
		}
		model.addAttribute("idAlumno", idAlumno);
		return Constantes.FORM_COMENTARIO;
	}
	
	// Metodo redirect
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/comentarios/listComentarios");
	}
	
}
