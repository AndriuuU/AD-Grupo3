package com.gestioncursos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.gestioncursos.constantes.Constantes;
import com.gestioncursos.model.AlumnosModel;
import com.gestioncursos.repository.CursosRepository;
import com.gestioncursos.repository.MatriculaRepository;
import com.gestioncursos.repository.UserRepository;
import com.gestioncursos.service.AlumnosService;
import com.gestioncursos.service.CursosService;
import com.gestioncursos.service.MatriculaService;
import com.gestioncursos.service.NoticiasService;
import com.gestioncursos.serviceImpl.UsersService;



@Controller
@RequestMapping("/alumnos")
public class AlumnosController {
	private static final String ALUMNOS_VIEW = "alumnos";
	private static final String FORM_VIEW = "formAlumnos";
	
	@Autowired
	@Qualifier("alumnoService")
	private AlumnosService alumnosService;
	
	@Autowired
	@Qualifier("userService")
	private UsersService usersService;
	
	@Autowired
	@Qualifier("cursosService")
	private CursosService cursosService;
	
	@Autowired
	@Qualifier("cursosRepository")
	private CursosRepository cursosRepository;
	
	@Autowired
	@Qualifier("matriculaService")
	private MatriculaService matriculaService;
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("noticiaService")
	private NoticiasService noticiaService;
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
//	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/alumnos/listAlumnos");
	}
	
	@PostMapping("/addAlumno")
	public String addAlumno(@Valid @ModelAttribute("alumno") AlumnosModel studentModel, BindingResult bindingResult,
			RedirectAttributes flash, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("curso", cursosService.listAllCursos());
			return ALUMNOS_VIEW;
		} else {
			alumnosService.updateAlumno(studentModel);
			flash.addFlashAttribute("success", "Alumno actualizado satisfactoriamente");
			return ALUMNOS_VIEW;
		}
	}
	
	@GetMapping("/formAlumno/{id}")
	public String formAlumno(@PathVariable(name = "id", required = false) int id, Model model) {
			model.addAttribute("alumno", alumnosService.findAlumno(id));
		return FORM_VIEW;
	}
	
	// Listar alumnos
	@GetMapping(value={"/listAlumnos","/listAlumnos/{id}"})
	public ModelAndView listAlumnos(@PathVariable(name="id") Integer id) {
		ModelAndView mav = new ModelAndView(ALUMNOS_VIEW);
		if(id==null)
			mav.addObject("alumnos", alumnosService.listAllAlumnos());
		else
			mav.addObject("alumnos", alumnosService.listAllAlumnos()
					.stream()
					.filter(x->x.getIdAlumno() == matriculaRepository.findByCurso(id).getAlumno().getIdAlumno()));
		return mav;
	}
	
	
	
	// Metodo de borrar
	@GetMapping("/deleteAlumno/{id}")
	public String deleteAlumno(@PathVariable("id") int id, RedirectAttributes flash) {
		if (alumnosService.removeAlumno(id) == 0)
			flash.addFlashAttribute("success", "Alumno eliminado con éxito");
		else
			flash.addFlashAttribute("error", "No se pudo eliminar el alumno");
		return "redirect:/alumnos/listAlumnos";
	}

	@GetMapping("/activarUsuario/{username}")
	public String activate(@PathVariable("username")String username, RedirectAttributes flash) {
		int i=usersService.activar(username);
		if(i==1) {
			flash.addFlashAttribute("success","Alumno activado con éxito");
		}else if(i==0) {
			flash.addFlashAttribute("warning","Alumno desactivado con éxito");
		}else
			flash.addFlashAttribute("error","No se ha podido activar/desactivar el usuario");	
		return "redirect:/alumnos/listAlumnos";
	}
	
	@GetMapping("/listCursos")
	public ModelAndView listCursosAlumnos() {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_ALUMNOS_VIEW);
		mav.addObject("cursos", cursosService.listAllCursos());
		return mav;
	}
	
	@GetMapping("/listCursos/nivelasc")
	public ModelAndView listCursosFechaAsc() {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_ALUMNOS_VIEW);
		mav.addObject("cursos", cursosService.listAllCursosByNivelAsc());
		return mav;
	}
	
	@GetMapping("/listCursos/niveldesc")
	public ModelAndView listCursosFechaDesc() {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_ALUMNOS_VIEW);
		mav.addObject("cursos", cursosService.listAllCursosByNivelDesc());
		return mav;
	}
	
	@GetMapping("/listCursos/disponibles")
	public ModelAndView listCursosDisponibles(Authentication auth) {
		System.out.println(auth.getName());
		ModelAndView mav = new ModelAndView(Constantes.COURSES_ALUMNOS_VIEW);
		mav.addObject("cursos", cursosService.ListAllCursosDisponibles(auth.getName()));
		return mav;
	}
	

	@GetMapping("/listNoticias")
	public ModelAndView listNoticiasAlumnos() {
		ModelAndView mav = new ModelAndView(Constantes.NOTICIAS_ALUMNOS);
		mav.addObject("noticias", noticiaService.listAllNoticias());
		return mav;
	}
}
