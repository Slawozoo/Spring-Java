package com.mavenmvc.MavenWebProject.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavenmvc.MavenWebProject.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
	
	/**
	 * Default method to set static Role while creating User
	 */
	default Set<Roles> getDefaultRole() {
		Set<Roles> roles = new HashSet<Roles>();
		Roles role = new Roles();
		role.setRoleId(2);
		role.setName("CUSTOMER");
		roles.add(role);
		return roles;
	}
}
