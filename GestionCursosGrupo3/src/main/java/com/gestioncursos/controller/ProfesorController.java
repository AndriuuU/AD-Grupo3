package com.gestioncursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.gestioncursos.model.ProfesoresModel;
import com.gestioncursos.service.CursosService;
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

	
}
