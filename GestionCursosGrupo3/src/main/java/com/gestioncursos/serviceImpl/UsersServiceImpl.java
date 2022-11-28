package com.gestioncursos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestioncursos.entity.User;
import com.gestioncursos.model.UserModel;
import com.gestioncursos.repository.UserRepository;
import com.gestioncursos.service.UserService;

@Service("userServie")
public class UsersServiceImpl implements UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public List<UserModel> listAllUsers() {
		return null;
		//return userRepository.findAll().stream().map(c->transform(c).collect(Collectors.toList()));
	}

	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public int removeUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User updateUser(UserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel findUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
