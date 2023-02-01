package com.gestioncursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GestionCursosGrupo3Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GestionCursosGrupo3Application.class, args);
	}
	
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(GestionCursosGrupo3Application.class);
	  }

}
