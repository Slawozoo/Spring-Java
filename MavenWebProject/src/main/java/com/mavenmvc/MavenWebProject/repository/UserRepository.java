package com.mavenmvc.MavenWebProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavenmvc.MavenWebProject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	/**
	 * Method to find User using username 
	 */
	User findByUsername(String username);
}
