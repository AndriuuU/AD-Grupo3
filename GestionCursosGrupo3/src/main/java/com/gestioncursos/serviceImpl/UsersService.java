package com.gestioncursos.serviceImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.gestioncursos.repository.UserRepository;

@Service("userService")
public class UsersService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException {
		com.gestioncursos.entity.User usuario = userRepository.findByUsername(gmail);

		UserBuilder builder = null;

		if (usuario != null) {
			builder = User.withUsername(gmail);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));

		} else
			throw new UsernameNotFoundException("User Not Found");
		return builder.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public com.gestioncursos.entity.User registrar(com.gestioncursos.entity.User usuario) {
		usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));
		usuario.setEnabled(false);
		usuario.setRole(usuario.getRole());
		return userRepository.save(usuario);
	}
	
	public int activar(String username) {
		int a=0;
		com.gestioncursos.entity.User u=userRepository.findByUsername(username);
		com.gestioncursos.entity.User user=new com.gestioncursos.entity.User();
		user.setPassword(passwordEncoder().encode(u.getPassword()));
		user.setUsername(u.getUsername());
		user.setId(u.getId());
		if(u.isEnabled()==false) {
			user.setEnabled(true);
			a=1;
		}else {
			user.setEnabled(false);
			a=0;
		}
		user.setRole(u.getRole());
		
		userRepository.save(user);
		return a;
	}
	
	public void deleteUser(String username) throws Exception {
		com.gestioncursos.entity.User u = userRepository.findByUsername(username);
		userRepository.delete(u);
	}
	
	public List<com.gestioncursos.entity.User> listAllUsuarios() {
		return userRepository.findAll().stream().collect(Collectors.toList());
	}
	
}
