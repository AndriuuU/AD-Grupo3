package com.gestioncursos.controller;

import java.util.List;
import java.util.stream.Stream;

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
import com.gestioncursos.model.ComentariosModel;
import com.gestioncursos.model.CursosModel;
import com.gestioncursos.repository.ComentariosRepository;
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
	public ModelAndView listComentarios(@PathVariable("idCurso") Integer idCurso) {
		ModelAndView mav = new ModelAndView(Constantes.COMMENTS_VIEW);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userEmail = authentication.getName();
	    Integer idAlumno = alumnoService.findByEmail(userEmail).getIdAlumno();
	    List<ComentariosModel> comentarios = comentariosService.listAllComentarios();
	    
	   
	    System.out.println(comentarios);		
	    mav.addObject("idAlumno", idAlumno);
	    mav.addObject("idCurso", idCurso);
	    mav.addObject("nombreCurso", cursosService.findCurso(idCurso).getNombre());
//	    System.out.println(comentariosService.listAllComentarios().stream().filter(x->x.getIdCurso()==idCurso));
		mav.addObject("comentarios", comentariosService.listAllComentarios());
		return mav;	
	}

	@PostMapping("/addComentario")
	public String addComentario(@ModelAttribute("comentario") ComentariosModel comentarioModel, RedirectAttributes flash) {
			comentariosService.addComentario(comentarioModel);
//			flash.addFlashAttribute("success", "Comentario insertado con éxito");
		return "redirect:/alumnos/listCursos";
	}

	@GetMapping(value = { "/formComentario/{idCurso}/{idAlumno}", "/formComentario/{id}" })
	public ModelAndView formComentario(@PathVariable(name = "id", required = false) Integer id,@PathVariable(name = "idCurso", required = false) Integer idCurso,@PathVariable(name = "idAlumno", required = false) 
	Integer idAlumno, Model model) {
		ModelAndView mav = new ModelAndView(Constantes.FORM_COMENTARIO);
		ComentariosModel comentario=new ComentariosModel();
        comentario.setIdCurso(idCurso);
        comentario.setIdAlumno(idAlumno);
        
	    if (id == null) {
			model.addAttribute("comentario", new ComentariosModel());
		}
		else {
			model.addAttribute("comentario", comentariosService.findComentario(id));
		}
	    model.addAttribute("comentario", comentario);
	    mav.addObject("idAlumno", idAlumno);
	    mav.addObject("idCurso", idCurso);
		
		return mav;
	}
	
	// Metodo redirect
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/comentarios/listComentarios");
	}
	
}
