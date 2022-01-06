package com.springsecurity.SpringSecurityMavenMvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.SpringSecurityMavenMvc.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

}
