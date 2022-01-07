package com.mavenmvc.MavenWebProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mavenmvc.MavenWebProject.model.User;
import com.mavenmvc.MavenWebProject.repository.RolesRepository;
import com.mavenmvc.MavenWebProject.repository.UserRepository;
import com.mavenmvc.MavenWebProject.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(new HashSet<>(rolesRepository.findAll()));
        //Static role assign to the user
		user.setRoles(rolesRepository.getDefaultRole());
        userRepository.save(user);	
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}
}
