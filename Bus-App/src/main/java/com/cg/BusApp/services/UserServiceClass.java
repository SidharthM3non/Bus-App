package com.cg.BusApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BusApp.entities.User;
import com.cg.BusApp.exceptions.UserAlreadyExistsException;
import com.cg.BusApp.repositories.IUserRepository;

@Service
public class UserServiceClass implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public void addUser(User u) {
		User user = userRepository.findByUsername(u.getUsername());
		if(user == null) {
			userRepository.save(u);
		}
		else {
			throw new UserAlreadyExistsException("User with following name already exists: " + u.getUsername());
		}
	}

	@Override
	public void deleteUser(User u) {
		Optional<User> user = userRepository.findById(u.getId());
		if(user.isPresent()) {
			userRepository.delete(u);
		}	
	}

	@Override
	public void updatePassword(String oldPassword, String newPassword) {
		User user = userRepository.findByPassword(oldPassword);
		user.setPassword(newPassword);
	}

}
