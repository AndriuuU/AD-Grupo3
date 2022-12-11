package com.gestioncursos.controller;

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

import com.gestioncursos.model.CursosModel;
import com.gestioncursos.service.CursosService;
import com.gestioncursos.service.ProfesoresService;

@Controller
@RequestMapping("/cursos")
public class CursoController {
	private static final String COURSES_VIEW = "cursos";
	private static final String FORM_VIEW = "formCurso";

	@Autowired
	@Qualifier("cursosService")
	private CursosService cursoService;

//	@PreAuthorize("hasRole('ROLE_ADMIN')") NO BORRAR
	@GetMapping("/listCursos")
	public ModelAndView listCursos() {
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("cursos", cursoService.listAllCursos());
		return mav;
	}

	@PostMapping("/addCurso")
	public String addCurso(@ModelAttribute("curso") CursosModel cursoModel, 
			RedirectAttributes flash) {
		if (cursoModel.getIdcursos() == 0) {
			cursoService.addCurso(cursoModel);
			flash.addFlashAttribute("success", "Curso insertado con éxito");

		} else {
			cursoService.updateCurso(cursoModel);
			flash.addFlashAttribute("success", "Curso modificado con éxito");
		}
		return "redirect:/cursos/listCursos";
	}

	@GetMapping(value = { "/formCurso", "/formCurso/{idCursos}" })
	public String formCurso(@PathVariable(name = "idCursos", required = false) Integer id, Model model) {
		model.addAttribute("cursos", cursoService.listAllCursos());
		if (id == null)
			model.addAttribute("curso", new CursosModel());
		else
			model.addAttribute("curso", cursoService.findCurso(id));
		return FORM_VIEW;
	}
	
	
	// Metodo de borrar
	@GetMapping("/deleteCurso/{idCursos}")
	public String deleteCurso(@PathVariable("idCursos") int id, RedirectAttributes flash) {
		if (cursoService.removeCurso(id) == 0)
			flash.addFlashAttribute("success", "Curso eliminado con éxito");
		else
			flash.addFlashAttribute("error", "No se pudo eliminar el curso");
		return "redirect:/cursos/listCursos";
	}
	
	// Metodo redirect
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/cursos/listCursos");
	}
}
