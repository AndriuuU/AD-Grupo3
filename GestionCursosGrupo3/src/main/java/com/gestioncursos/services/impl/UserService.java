package com.gestioncursos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gestioncursos.repository.UserRepository;


@Service("userService")
public class UserService implements UserDetailsService{
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException {
		com.gestioncursos.entity.User usuario=userRepository.findByUsername(gmail);
		
		UserBuilder builder=null;
		
		if(usuario!=null) {
			builder=User.withUsername(gmail);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));
		}
		else 
			throw new UsernameNotFoundException("Usuario no encontrado");
		return builder.build();
	}

}
