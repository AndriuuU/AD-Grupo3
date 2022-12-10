package com.gestioncursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.gestioncursos.entity.Alumnos;
import com.gestioncursos.entity.User;
import com.gestioncursos.service.AlumnosService;
import com.gestioncursos.serviceImpl.UsersService;


@Controller
@RequestMapping("/")
public class LoginController {
	private static final String HOME_VIEW = "home";
	private static final String LOGIN_VIEW = "login";
	private static final String REGISTER_VIEW = "register";
	@Autowired
	@Qualifier("userService")
	private UsersService usuarioService;
	
	@Autowired
	@Qualifier("alumnoService")
	private AlumnosService alumnoService;
	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/home");
	}
	
	@GetMapping("/home")
	public String inicio(Model model) {
		return HOME_VIEW;
	}
	
	@GetMapping("/auth/login")
	public String login (Model model,@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false)String logout) {
		model.addAttribute("user",new User());
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return LOGIN_VIEW;
	}
	
	@GetMapping("/auth/registerForm")
	public String registerForm(Model model) {
		model.addAttribute("alumno", new Alumnos());
		return REGISTER_VIEW;
	}
	
	@PostMapping("/auth/register")
	public String register(@ModelAttribute Alumnos alumno,RedirectAttributes flash) {
		alumnoService.addAlumno(alumnoService.transform(alumno));
		User user = new User();
		user.setUsername(alumno.getEmail());
		user.setPassword(alumno.getPassword());
		user.setRole("ROL_ALUMNO");
		usuarioService.registrar(user);
		flash.addFlashAttribute("success","User registered successfully");
		
		return "redirect:/auth/login";
	}
	
}
