package com.gestioncursos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.gestioncursos.constantes.Constantes;
import com.gestioncursos.entity.Noticias;
import com.gestioncursos.entity.User;
import com.gestioncursos.model.NoticiasModel;
import com.gestioncursos.repository.NoticiasRepository;
import com.gestioncursos.repository.UserRepository;
import com.gestioncursos.service.NoticiasService;
import com.gestioncursos.storage.StorageService;

@Controller
@RequestMapping("/noticia")
public class NoticiaController {

	@Autowired
	@Qualifier("noticiaService")
	private NoticiasService noticiasService;
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("noticiaRepository")
	private NoticiasRepository noticiaRepository;
	
	@Autowired
	@Qualifier("storageService")
	private StorageService storageService;
	
	@GetMapping("/listNoticias")	
	public ModelAndView listNoticias() {
		ModelAndView mav = new ModelAndView(Constantes.NOTICIAS_VIEW);
		mav.addObject("noticias", noticiasService.listAllNoticias());
		return mav;
	}
		
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/noticias/listNoticias");
	}
	
	
	@PostMapping("/addNoticia")
	public String addNoticias(@Valid @ModelAttribute("noticia") NoticiasModel noticiaModel,Model model,
			 RedirectAttributes flash,BindingResult bindingResult,@RequestParam("file")MultipartFile file) {
		
		UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u=userRepository.findByUsername(userDetails.getUsername());
		
		
			String imagen=storageService.store(file,noticiaModel.getTitulo());
			noticiaModel.setImagen(imagen);
			
			if(noticiaModel.getIdNoticias()==0) {
				
				Noticias n =noticiaRepository.findByTitulo(noticiaModel.getTitulo());
				if(n!=null) {
					return "redirect:/noticias/formNoticia?error";
					
				}else {
					
					noticiaModel.setIdAdmin(u.getId());
					noticiasService.addNoticia(noticiaModel);
					flash.addFlashAttribute("success","Noticia creada con éxito");	
				}
					
			}else {
				noticiasService.updateNoticia(noticiaModel);
				flash.addFlashAttribute("success", "Noticia modificada con éxito");
			}
			return "redirect:/noticia/listNoticias/";
		
		
	
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
		return Constantes.FORM_NOTICIAS;
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
