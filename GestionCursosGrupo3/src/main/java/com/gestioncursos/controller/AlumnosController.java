package com.gestioncursos.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
import com.gestioncursos.model.CursosModel;
import com.gestioncursos.model.MatriculaModel;
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
	
	
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("noticiaService")
	private NoticiasService noticiaService;
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
//	
	@GetMapping("/home")
	public RedirectView redirect() {
		return new RedirectView("/alumnos/listNoticias");
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
	@GetMapping(value = {"/listAlumnos/{idCurso}","/listAlumnos"})
	public ModelAndView listAlumnos(@PathVariable(name="idCurso", required = false) Integer idCurso) {
		ModelAndView mav = new ModelAndView(ALUMNOS_VIEW);
		List<AlumnosModel> listAlumnos = alumnosService.listAllAlumnos();
		List<AlumnosModel> alumnos = new ArrayList<>();
		
		
		if(idCurso == null) {
			mav.addObject("alumnos", listAlumnos);
		}else {
		List<MatriculaModel> matriculas = matriculaService.listMatriculasCurso(idCurso);
		CursosModel cursos = cursosService.findCurso(idCurso);

		long millis = System.currentTimeMillis();
		Date today = new java.sql.Date(millis);
		
		boolean finalizado = cursos.getFechaFin().before(today);
		
		for(AlumnosModel a : listAlumnos) {
			for(MatriculaModel m : matriculas) {
				if(a.getIdAlumno() == m.getIdAlumno()) {
					alumnos.add(a);
				}
			}
		}
		mav.addObject("cursos", cursos);
		mav.addObject("matriculas", matriculas);
		mav.addObject("alumnos", alumnos);
		mav.addObject("finalizado", finalizado);
		}
		
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
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    String userEmail = authentication.getName();
		    int idAlumno = alumnosService.findByEmail(userEmail).getIdAlumno();
			mav.addObject("cursos", cursosService.listAllCursos());
			mav.addObject("idAlumno", idAlumno);
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
	
	@GetMapping("/listCursos/nivel/{nivel}")
	public ModelAndView listCursosPorNivel(@PathVariable(name = "nivel") String nivel, Model model) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_ALUMNOS_VIEW);
		List<CursosModel> listCursos = cursosService.listAllCursos();
		List<CursosModel> cursos = new ArrayList<>();
		
		for(CursosModel c : listCursos) {
			if(nivel.equals("basico")) {
				if(c.getNivel()<=4) {
					cursos.add(c);
				}
			}
			else if(nivel.equals("medio")) {
				if(c.getNivel()>4 && c.getNivel()<=8) {
					cursos.add(c);
				}
			}
			else if(nivel.equals("avanzado")) {
				if(c.getNivel()>8) {
					cursos.add(c);
				}
			}
		}
		
		mav.addObject("cursos", cursos);
		
		return mav;
	}
	
	@GetMapping("/listCursos/disponibles")
	public ModelAndView listCursosAlumnoDisponible(Authentication auth, Model model) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_ALUMNOS_DISPONIBLES_VIEW);
		AlumnosModel alumno = alumnosService.findAlumno(auth.getName());
		
		int idAlumno = alumnosService.findAlumno(auth.getName()).getIdAlumno();
		List<CursosModel> listCursos = cursosService.listAllCursos();
		List<MatriculaModel> matriculas = matriculaService.listMatriculasAlumno(idAlumno);
		List<CursosModel> cursos = new ArrayList<>();
		boolean matriculado;
		
		for(CursosModel c : listCursos) {
			matriculado = false;
			for(MatriculaModel m : matriculas) {
				if((m.getIdCurso() == c.getIdCurso()) && (m.getIdAlumno() == idAlumno)) {
					matriculado = true;
				}
			}
			if(matriculado == false) {
				cursos.add(c);
			}
		}
		mav.addObject("alumnos", alumno);
		mav.addObject("cursos", cursos);
		return mav;
	}
	
	@GetMapping("/listCursos/matriculados")
	public ModelAndView listCursosMatriculados(Authentication auth) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_ALUMNOS_VIEW);
		AlumnosModel alumno = alumnosService.findAlumno(auth.getName());
		mav.addObject("cursos", cursosService.listCursosAlumno(alumno.getIdAlumno()));
		return mav;
	}
	
	@GetMapping("/matricularse/{idCurso}")
	public String matricularse(@PathVariable("idCurso") Integer idCurso, @ModelAttribute("matricula") MatriculaModel matriculaModel,
			RedirectAttributes flash, Authentication auth) {
		AlumnosModel alumno = alumnosService.findAlumno(auth.getName());
		matriculaModel.setIdAlumno(alumno.getIdAlumno());
		matriculaModel.setIdCurso(idCurso);
		matriculaService.addMatricula(matriculaModel);
		flash.addFlashAttribute("success", "Matriculado con éxito");
		return "redirect:/alumnos/listCursos/disponibles";
	}
	

	@GetMapping("/listNoticias")
	public ModelAndView listNoticiasAlumnos() {
		ModelAndView mav = new ModelAndView(Constantes.NOTICIAS_ALUMNOS);
		mav.addObject("noticias", noticiaService.listAllNoticias());
		return mav;
	}
	
	@GetMapping("/listNotas")
	public ModelAndView listNotas(Authentication auth) {
		ModelAndView mav = new ModelAndView(Constantes.NOTAS_CALIFICADOS);
		AlumnosModel alumno = alumnosService.findAlumno(auth.getName());
		List<CursosModel> cursosAlumno = cursosService.listCursosAlumno(alumno.getIdAlumno());
		List<MatriculaModel> matriculasAlumno = matriculaService.listMatriculasAlumno(alumno.getIdAlumno());
		
		mav.addObject("cursos", cursosAlumno);
		mav.addObject("matriculas", matriculasAlumno);
	
		return mav;
	}
}
