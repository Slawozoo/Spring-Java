package com.springsecurity.SpringSecurityMavenMvc.service.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.SpringSecurityMavenMvc.model.User;
import com.springsecurity.SpringSecurityMavenMvc.repository.RolesRepository;
import com.springsecurity.SpringSecurityMavenMvc.repository.UserRepository;
import com.springsecurity.SpringSecurityMavenMvc.service.UserService;

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
        user.setRoles(new HashSet<>(rolesRepository.findAll()));
        userRepository.save(user);	
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
