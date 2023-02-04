package com.gestioncursos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	  @Bean
	  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	      http.authorizeRequests((requests)->requests
	        .antMatchers("/", "/imgs/","/photos/","/auth/**","/webjars/**","/css/**","/noticias/**","/files/**").permitAll()
	        .antMatchers("/cursos/listCursos/","/cursos/listCursosAlumno/","/cursos/addCurso/","/curso/formCurso/**").hasAnyAuthority("ROL_ADMIN","ROL_PROFESOR")
	        .antMatchers("/comentarios/**","/matricula/**","/cursos/listCursos/notasCursosFinalizados/**","/profesores/listCursos/notasCursosFinalizados/**").hasAnyAuthority("ROL_PROFESOR")
	        .antMatchers("/noticias/formNoticias/**","/noticias/deleteNoticia/**","/profesor/addProfesor","profesor/formProfesor/**","/profesor/deleteProfesor","/profesor/activarUsuario","/cursos/listAlumnosOrdenados","/cursos/listaMejoresNotas/**","/cursos/listTopCursos").hasAnyAuthority("ROL_ADMIN")
	        .antMatchers("/comentarios/**","/alumnos/listCursos/nivelasc","/alumnos/listCursos/niveldesc","/alumnos/listCursos/disponibles","/alumnos/listCursos/matriculados","/alumnos/matricularse/**","/alumnos/listNotas","/cursos/listCursos","/cursos/listCursosAlumno").hasAnyAuthority("ROL_ALUMNO")
	        .antMatchers("/alumnos/**").hasAnyAuthority("ROL_ALUMNO","ROL_PROFESOR","ROL_ADMIN")
	        .anyRequest().authenticated())
	        
	      .formLogin((form)->form 
	        .loginPage("/auth/login")
	        .defaultSuccessUrl("/home",true)
	        .permitAll())
	        
	      .logout((logout)->logout.permitAll()
	        .logoutUrl("/auth/logout")
	        .logoutSuccessUrl("/auth/login?logout"));

	    return http.build();
	  }
	  
	  protected void configure(HttpSecurity http) throws Exception {
	      http
	          .logout(logout -> logout                                                
	              .logoutUrl("/auth/logout")                                            
	              .logoutSuccessUrl("/auth/login")                                      
	              .invalidateHttpSession(true)
	                                      
	          );
	  }
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}

}
