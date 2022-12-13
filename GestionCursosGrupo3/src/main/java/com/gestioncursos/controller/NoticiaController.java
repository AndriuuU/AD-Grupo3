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

import com.gestioncursos.model.NoticiasModel;
import com.gestioncursos.service.NoticiasService;

@Controller
@RequestMapping("/noticia")
public class NoticiaController {
	private static final String NOTICIAS_VIEW = "noticias";
	private static final String FORM_NOTICIAS = "formNoticias";
	
	@Autowired
	@Qualifier("noticiaService")
	private NoticiasService noticiasService;
	
	@GetMapping("/listNoticias")
	public ModelAndView listAlumnos() {
		ModelAndView mav = new ModelAndView(NOTICIAS_VIEW);
		mav.addObject("noticias", noticiasService.listAllNoticias());
		return mav;
	}
	
	@PostMapping("/addNoticia")
	public String addNoticia(@ModelAttribute("noticia") NoticiasModel noticiasModel, 
			RedirectAttributes flash) {
		if (noticiasModel.getIdNoticia() != 0) {
			noticiasService.updateNoticia(noticiasModel);
			flash.addFlashAttribute("success", "Noticia modificado con éxito");
		} else {
			noticiasService.addNoticia(noticiasModel);
			flash.addFlashAttribute("success", "Noticia insertado con éxito");
		}
		return "redirect:/noticia/listNoticias";
	}
	
	@GetMapping(value = { "/formNoticias", "/formNoticias/{id}" })
	public String formNoticia(@PathVariable(name = "id", required = false) Integer id, Model model) {
		if (id == null) {
			model.addAttribute("noticia", new NoticiasModel());
		}
		else {
			model.addAttribute("noticia", noticiasService.findNoticia(id));
			System.out.println(id);
		}
		return FORM_NOTICIAS;
	}
	
	@GetMapping("/deleteNoticia/{idNoticia}")
	public String deleteCurso(@PathVariable("idNoticia") int id, RedirectAttributes flash) {
		if (noticiasService.removeNoticia(id) == 0)
			flash.addFlashAttribute("success", "Noticia eleminada eliminado con éxito");
		else
			flash.addFlashAttribute("error", "No se pudo eliminar la noticia");
		return "redirect:/noticia/listNoticias";
	}
	
	

}
