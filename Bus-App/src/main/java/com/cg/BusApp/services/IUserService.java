package com.cg.BusApp.services;

import com.cg.BusApp.entities.User;

public interface IUserService {
	
	public void addUser(User u);
	
	public void deleteUser(User u);
	
	public void updatePassword(String oldPassword, String newPassword);

}
