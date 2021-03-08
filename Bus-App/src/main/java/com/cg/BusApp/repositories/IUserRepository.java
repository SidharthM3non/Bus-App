package com.cg.BusApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BusApp.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);

	User findByPassword(String oldPassword);

}
