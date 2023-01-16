package com.gestioncursos.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.gestioncursos.model.AlumnosModel;
import com.gestioncursos.model.CursosModel;
import com.gestioncursos.model.MatriculaModel;
import com.gestioncursos.model.ProfesoresModel;
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
	@Qualifier("userService")
	private UsersService usersService;
	
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
	
	// listar cursos por id del profesor
	@GetMapping("/listCursos/{idProfesores}")
	public ModelAndView listCursos(@PathVariable("idProfesores") int id) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		mav.addObject("cursos", cursosService.listAllCursosProfesor(id));
		return mav;
	}
	
//	@GetMapping(value = {"/listCursos/{idProfesores}/fechaasc","/listCursos/{idProfesores}/fechadesc"})

	
	@GetMapping("/listCursos/{idProfesores}/fechaasc")
	public ModelAndView listCursosFechaAsc(@PathVariable("idProfesores") int id) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		List<CursosModel> listCursosFechas =cursosService.listAllCursosProfesor(id);
		
		Collections.sort(listCursosFechas, (x, y) -> x.getFechaInicio().compareTo(y.getFechaInicio()));
		
		
		mav.addObject("cursos", listCursosFechas);
		
		return mav;
	}
	
	@GetMapping("/listCursos/{idProfesores}/fechadesc")
	public ModelAndView listCursosFechaDesc(@PathVariable("idProfesores") int id) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		List<CursosModel> listCursosFechas =cursosService.listAllCursosProfesor(id);
		
		Collections.sort(listCursosFechas, (x, y) -> y.getFechaInicio().compareTo(x.getFechaInicio()));
		
		mav.addObject("cursos", listCursosFechas);
		
		return mav;
	}
	
	@GetMapping("/listCursos/{idProfesores}/impartiran")
	public ModelAndView listCursosImpartiran(@PathVariable("idProfesores") int id) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis); 
		
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
	
	@GetMapping("/listCursos/{idProfesores}/impar")
	public ModelAndView listCursosImpartiendo(@PathVariable("idProfesores") int id) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis); 
		
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
	
	@GetMapping("/listCursos/{idProfesores}/impartido")
	public ModelAndView listCursosImpartido(@PathVariable("idProfesores") int id) {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis); 
		
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
	
	@GetMapping("/listCursos/{idProfesores}/califica/{idCurso}")
	public ModelAndView listCursosCalifica(@PathVariable("idProfesores") int idProfesor,@PathVariable("idCurso") int idCurso) {
		ModelAndView mav = new ModelAndView(Constantes.CALIFICA_ALUMNOS_CURSO);
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis); 
		
		List<MatriculaModel> listMatriCursos =matriculaService.listMatriculasCurso(idCurso);
		
		List<AlumnosModel> listAlumnosMatriCurso=new ArrayList<>();
		for(MatriculaModel lista:listMatriCursos) {
			if(alumnosService.findAlumno(lista.getAlumno_id()) != null) {
				listAlumnosMatriCurso.add(alumnosService.findAlumno(lista.getAlumno_id()));
			}
		}
		
		mav.addObject("alumnos", listAlumnosMatriCurso);
		
		return mav;
	}
	
	
	
}
