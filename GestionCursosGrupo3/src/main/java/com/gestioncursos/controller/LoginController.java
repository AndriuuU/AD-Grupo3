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

import com.gestioncursos.constantes.Constantes;
import com.gestioncursos.entity.Alumnos;
import com.gestioncursos.entity.User;
import com.gestioncursos.model.AlumnosModel;
import com.gestioncursos.repository.UserRepository;
import com.gestioncursos.service.AlumnosService;
import com.gestioncursos.serviceImpl.UsersService;


@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	@Qualifier("userService")
	private UsersService userService;
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("alumnoService")
	private AlumnosService alumnoService;
	
	@GetMapping("/")
	public String home(Model model) {
		return Constantes.HOME_VIEW;
	}
	
	@GetMapping("/home")
	public String inicio(Model model) {
		return Constantes.HOME_VIEW;
	}
	
	@GetMapping("/auth/login")
	public String login (Model model,@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false)String logout) {
		model.addAttribute("user",new User());
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return Constantes.LOGIN_VIEW;
	}
	
	@GetMapping("/auth/registerForm")
	public String registerForm(Model model,@RequestParam(name="error",required=false)String error) {
		model.addAttribute("alumno", new Alumnos());
		model.addAttribute("error",error);
		return Constantes.REGISTER_VIEW;
	}
	
	@PostMapping("/auth/register")
	public String register(@ModelAttribute Alumnos alumno,RedirectAttributes flash) {	
		if(userRepository.findByUsername(alumno.getEmail())==null) {
			alumnoService.addAlumno(alumnoService.transform(alumno));
			User user = new User();
			user.setUsername(alumno.getEmail());
			user.setPassword(alumno.getPassword());
			user.setRole("ROL_ALUMNO");
			userService.registrar(user);
			flash.addFlashAttribute("success","User registered successfully");
			return Constantes.LOGIN_VIEW;
		}else {
			return "redirect:/auth/registerForm?error";
		}
		
	}
	
}
