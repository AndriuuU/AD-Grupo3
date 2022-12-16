package com.gestioncursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.gestioncursos.service.AlumnosService;
import com.gestioncursos.service.CursosService;
import com.gestioncursos.serviceImpl.UsersService;



@Controller
@RequestMapping("/alumnos")
public class AlumnosController {
	private static final String ALUMNOS_VIEW = "alumnos";
	
	@Autowired
	@Qualifier("alumnoService")
	private AlumnosService alumnosService;
	
	@Autowired
	@Qualifier("cursosService")
	private CursosService courseService;
	
	@Autowired
	@Qualifier("userService")
	private UsersService usersService;
		
//	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/alumnos/listAlumnos");
	}
	
	// Listar alumnos
	@GetMapping("/listAlumnos")
	public ModelAndView listAlumnos() {
		ModelAndView mav = new ModelAndView(ALUMNOS_VIEW);
		mav.addObject("alumnos", alumnosService.listAllAlumnos());
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
}
