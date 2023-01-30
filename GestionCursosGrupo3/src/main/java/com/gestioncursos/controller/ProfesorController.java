package com.gestioncursos.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
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
import com.gestioncursos.entity.Profesores;
import com.gestioncursos.model.AlumnosModel;
import com.gestioncursos.model.CursosModel;
import com.gestioncursos.model.MatriculaModel;
import com.gestioncursos.model.ProfesoresModel;
import com.gestioncursos.repository.ProfesoresRepository;
import com.gestioncursos.repository.UserRepository;
import com.gestioncursos.service.AlumnosService;
import com.gestioncursos.service.CursosService;
import com.gestioncursos.service.MatriculaService;
import com.gestioncursos.service.ProfesoresService;
import com.gestioncursos.serviceImpl.UsersService;


@Controller
@RequestMapping("/profesores")
public class ProfesorController {

	@Autowired
	@Qualifier("profesoresService")
	private ProfesoresService profesorService;
	
	@Autowired
	@Qualifier("profesorRepository")
	private ProfesoresRepository profesorRepository;
	
	@Autowired
	@Qualifier("userService")
	private UsersService usersService;
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("cursosService")
	private CursosService cursosService;
	
	@Autowired
	@Qualifier("matriculaService")
	private MatriculaService matriculaService;
	
	@Autowired
	@Qualifier("alumnoService")
	private AlumnosService alumnosService;
	

//	@PreAuthorize("hasRole('ROLE_ADMIN')") NO BORRAR
	@GetMapping("/listProfesores")
	public ModelAndView listProfesores() {
		ModelAndView mav = new ModelAndView(Constantes.PROFESORES_VIEW);
		mav.addObject("profesores", profesorService.listAllProfesores());
		return mav;
	}

	@PostMapping("/addProfesor")
	public String addProfesor(@ModelAttribute("profesor") ProfesoresModel profesorModel, 
			RedirectAttributes flash) {
		if (profesorModel.getIdProfesor() == 0) {
			profesorService.addProfesor(profesorModel);
			flash.addFlashAttribute("success", "Curso insertado con éxito");

		} else {
			profesorService.updateProfesor(profesorModel);
			flash.addFlashAttribute("success", "Curso modificado con éxito");
		}
		return "redirect:/cursos/listCursos";
	}

	@GetMapping(value = { "/formProfesor", "/formProfesor/{idProfesores}" })
	public String formProfesor(@PathVariable(name = "idProfesores", required = false) Integer id, Model model) {
		model.addAttribute("profesores", profesorService.listAllProfesores());
		if (id == null)
			model.addAttribute("profesor", new ProfesoresModel());
		else
			model.addAttribute("profesor", profesorService.findProfesor(id));
		return Constantes.FORM_PROFESORES;
	}
	
	
	// Metodo de borrar
	@GetMapping("/deleteProfesor/{idProfesores}")
	public String deleteProfesor(@PathVariable("idProfesores") int id, RedirectAttributes flash) {
		if (profesorService.removeProfesor(id) == 0)
			flash.addFlashAttribute("success", "Profesor eliminado con éxito");
		else
			flash.addFlashAttribute("error", "No se pudo eliminar el profesor");
		return "redirect:/profesores/listProfesores";
	}
	
	@GetMapping("/activarUsuario/{username}")
	public String activate(@PathVariable("username")String username, RedirectAttributes flash) {
		int i=usersService.activar(username);
		if(i==1) {
			flash.addFlashAttribute("success","Profesor activado con éxito");
		}else if(i==0) {
			flash.addFlashAttribute("success","Profesor desactivado con éxito");
		}else
			flash.addFlashAttribute("error","No se ha podido activar/desactivar el usuario");	
		return "redirect:/profesores/listProfesores";
	}
	
	// Metodo redirect
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/profesores/listProfesores");
	}
	
	// listar cursos por email del profesor
	@GetMapping("/listCursosEmail/{email}")
	public ModelAndView listCursoEmail(@PathVariable(name = "email", required = false) String email, Model model) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		Profesores p = profesorRepository.findByEmail(email);
		long id = p.getIdProfesor();
		System.out.println(id);
		mav.addObject("cursos", cursosService.listAllCursosProfesor(id));
		return mav;
	}
	
	// listar cursos por id del profesor
	/*
		@GetMapping("/listCursos/{idProfesores}")
		public ModelAndView listCursos(@PathVariable("idProfesores") int id) {
			ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
			List<CursosModel> listCursos =cursosService.listAllCursosProfesor(id);
			mav.addObject("cursos", cursosService.listAllCursosProfesor(id));
			return mav;
		}
		*/
	
//	@GetMapping(value = {"/listCursos/{idProfesores}/fechaasc","/listCursos/{idProfesores}/fechadesc"})

	
	@GetMapping("/listCursos/fechaasc/{email}")
	public ModelAndView listCursosFechaAsc(@PathVariable(name = "email", required = false) String email, Model model) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		Profesores p = profesorRepository.findByEmail(email);
		long id = p.getIdProfesor();
		List<CursosModel> listCursosFechas =cursosService.listAllCursosProfesor(id);
		Collections.sort(listCursosFechas, (x, y) -> x.getFechaInicio().compareTo(y.getFechaInicio()));
		mav.addObject("cursos", listCursosFechas);
		
		return mav;
	}
	
	@GetMapping("/listCursos/fechadesc/{email}")
	public ModelAndView listCursosFechaDesc(@PathVariable(name = "email", required = false) String email, Model model) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		Profesores p = profesorRepository.findByEmail(email);
		long id = p.getIdProfesor();
		List<CursosModel> listCursosFechas =cursosService.listAllCursosProfesor(id);
		Collections.sort(listCursosFechas, (x, y) -> y.getFechaInicio().compareTo(x.getFechaInicio()));
		mav.addObject("cursos", listCursosFechas);
		
		return mav;
	}
	
	@GetMapping("/listCursos/impartido/{email}")
	public ModelAndView listCursosImpartido(@PathVariable(name = "email", required = false) String email, Model model) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis); 
		Profesores p = profesorRepository.findByEmail(email);
		long id = p.getIdProfesor();
		
		List<CursosModel> listCursosFechas =cursosService.listAllCursosProfesor(id);
		
		List<CursosModel> listCursos=new ArrayList<>();
		for(CursosModel lista:listCursosFechas) {
			if(lista.getFechaFin().before(date)) {
				listCursos.add(lista);
			}
		}
		
		mav.addObject("cursos", listCursos);
		
		return mav;
	}
	
	@GetMapping("/listCursos/impartiran/{email}")
	public ModelAndView listCursosImpartiran(@PathVariable(name = "email", required = false) String email, Model model) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis); 
		Profesores p = profesorRepository.findByEmail(email);
		long id = p.getIdProfesor();
		
		List<CursosModel> listCursosFechas =cursosService.listAllCursosProfesor(id);
		
		List<CursosModel> listCursos=new ArrayList<>();
		for(CursosModel lista:listCursosFechas) {
			if(lista.getFechaInicio().after(date)) {
				listCursos.add(lista);
				
			}
		}
		
		mav.addObject("cursos", listCursos);
		
		return mav;
	}
	
	@GetMapping("/listCursos/impar/{email}")
	public ModelAndView listCursosImpartiendo(@PathVariable(name = "email", required = false) String email, Model model) {		
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis); 
		Profesores p = profesorRepository.findByEmail(email);
		long id = p.getIdProfesor();
		
		List<CursosModel> listCursosFechas =cursosService.listAllCursosProfesor(id);
		
		List<CursosModel> listCursos=new ArrayList<>();
		for(CursosModel lista:listCursosFechas) {
			if(lista.getFechaFin().after(date) && lista.getFechaInicio().before(date)) {
				listCursos.add(lista);
				
			}
		}
		
		mav.addObject("cursos", listCursos);
		
		return mav;
	}
	
	
	
	@GetMapping("/listCursos/califica/{idCurso}")
	public ModelAndView listCursosCalifica(@PathVariable(name = "idCurso", required = false) int idCurso, Model model) {
		ModelAndView mav = new ModelAndView(Constantes.CALIFICA_ALUMNOS_CURSO);
		
		CursosModel cursos = cursosService.findCurso(idCurso);
		List<AlumnosModel> listAlumnos = alumnosService.listAllAlumnos();
		List<MatriculaModel> matriculas = matriculaService.listMatriculasCurso(idCurso);	
		List<AlumnosModel> alumnos = new ArrayList<>();
		
		long millis = System.currentTimeMillis();
        Date today = new java.sql.Date(millis);
		
        boolean finalizado = cursos.getFechaFin().before(today);
		
		for(AlumnosModel a : listAlumnos) {
			for(MatriculaModel m : matriculas)
			if(a.getIdAlumno() == m.getIdAlumno()) {
				alumnos.add(a);
			}
		}
		mav.addObject("cursos", cursos);
		mav.addObject("matriculas", matriculas);
		mav.addObject("alumnos", alumnos);
		mav.addObject("finalizado",finalizado);
				
		return mav;
	}
	
	// Isertar curso para el profesor
	@GetMapping("/formCursos/{email}" )
	public String formCursos(@PathVariable(name = "email", required = false) String email, Model model) {
		model.addAttribute("profesores", profesorService.findProfesor(email));
		
		model.addAttribute("curso", new CursosModel());
		
		return Constantes.FORM_COURSE;
	}
	
	@PostMapping("/addCurso")
	public String addCurso(@ModelAttribute("curso") CursosModel cursoModel, 
			RedirectAttributes flash) {
		
			cursosService.addCurso(cursoModel);
			flash.addFlashAttribute("success", "Curso insertado con éxito");
		
		return "redirect:/profesores/listCursos";
	}
	
	@GetMapping("/listCursos/misAlumnos")
	public ModelAndView notasCursosFinalizados(@PathVariable("idProfesor") Integer idProfesor, Authentication auth) {
		ModelAndView mav = new ModelAndView(Constantes.NOTAS_CURSOS_FINALIZADOS);
		//AlumnosModel alumno = alumnosService.findAlumno(auth.getName());
		
		int idProf = profesorService.findProfesor(auth.getName()).getIdProfesor();
		//int idAlumno = alumnosService.findAlumno(auth.getName()).getIdAlumno();
		List<CursosModel> listCursos = cursosService.listAllCursos();
		//List<MatriculaModel> matriculasAlumno = matriculaService.listMatriculasAlumno(alumno.getIdAlumno());
		List<CursosModel> cursos = new ArrayList<>();

		for(CursosModel c : listCursos) {
			if(c.getIdProfesor()==idProf) {
				if((c.getFechaFin().toLocalDate()).isBefore(LocalDate.now())) {
					cursos.add(c); //lista de cursos que imparte el profesor loggeado y ya finalizados
				} 
			}
		}
		
		for(CursosModel cu : cursos) {
			
		}
		
		//mav.addObject("alumnos", alumno);
		mav.addObject("cursos", cursos);
		return mav;
    }
		
	
	
	
	
}
