package com.gestioncursos.service;

import java.util.List;

import com.gestioncursos.entity.User;
import com.gestioncursos.model.UserModel;

public interface UserService {

	public abstract List<UserModel> listAllUsers();
	public abstract User addUser(User user);
	public abstract int removeUser(int id);
	public abstract User updateUser(UserModel userModel);
	public abstract UserModel findUser(int id);

	
}
