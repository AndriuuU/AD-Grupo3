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
	        .antMatchers("/", "/imgs/","/photos/","/auth/**","/webjars/**","/css/**","/cursos/**","/noticias/**","/files/**").permitAll()
	        .antMatchers("/profesores/**","/alumnos/**").hasRole("ROLE_ADMIN")
	        .antMatchers("/alumnos/**","/comentarios/**","/matricula/**").hasRole("ROLE_PROFESOR")
	        .antMatchers("/alumnos/**","/comentarios/**").hasRole("ROLE_ALUMNO")
	        .anyRequest().authenticated())
	        
	      .formLogin((form)->form 
	        .loginPage("/auth/login")
	        .defaultSuccessUrl("/cursos/",true)
	        .permitAll())
	        
	      .logout((logout)->logout.permitAll()
	        .logoutUrl("/logout")
	        .logoutSuccessUrl("/auth/login?logout"));

	    return http.build();
	  }
	  
	  protected void configure(HttpSecurity http) throws Exception {
	      http
	          .logout(logout -> logout                                                
	              .logoutUrl("/my/logout")                                            
	              .logoutSuccessUrl("/auth/login")                                      
	              .invalidateHttpSession(true)
	                                      
	          );
	  }
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}

}
