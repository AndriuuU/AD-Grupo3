package com.gestioncursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.gestioncursos.service.AlumnosService;
import com.gestioncursos.serviceImpl.UsersService;


@Controller
@RequestMapping("/alumnos")
public class AlumnosController {
	private static final String ADMINALUMNOS_VIEW = "adminAlumnos";
	
	@Autowired
	@Qualifier("alumnoService")
	private AlumnosService alumnosService;
	
	@Autowired
	@Qualifier("userService")
	private UsersService usersService;
	
//	
//	@GetMapping("/")
//	public RedirectView redirect() {
//		return new RedirectView("/alumnos/listAlumnos");
//	}
	
	// Listar alumnos
	@GetMapping("/listAlumnos")
	public ModelAndView listCursos() {
		ModelAndView mav = new ModelAndView(ADMINALUMNOS_VIEW);
		mav.addObject("alumnos", alumnosService.listAllAlumnos());
		return mav;
	}
	
	// Metodo de borrar
	@GetMapping("/deleteAlumnos/{idAlumnos}")
	public String deleteCurso(@PathVariable("idAlumnos") int id, RedirectAttributes flash) {
		if (alumnosService.removeAlumno(id) == 0)
			flash.addFlashAttribute("success", "Alumno eliminado con éxito");
		else
			flash.addFlashAttribute("error", "No se pudo eliminar el alumno");
		return "redirect:/cursos/listCursos";
	}
	
	@PostMapping("/activateAlumnos/{idAlumnos}")
	public String activateAlumno(@PathVariable("idAlumnos") int id, RedirectAttributes flash) {
		usersService.activar("username");
		flash.addFlashAttribute("success", "Alumno modificado");
		return "redirect:/alumnos/listAlumnos";
	}
}
