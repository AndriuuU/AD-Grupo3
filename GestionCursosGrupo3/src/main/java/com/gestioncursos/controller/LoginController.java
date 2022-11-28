package com.gestioncursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestioncursos.entity.User;
import com.gestioncursos.services.impl.UserService;

//@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("/auth/login")
	public String loging(Model model, @RequestParam(name="error", required=false)String error,
				@RequestParam(name="logout",required=false)String logout) {
		
		model.addAttribute("user", new User());
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "login";
		
		
	}
	

}
