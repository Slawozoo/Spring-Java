package com.mavenmvc.MavenWebProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavenmvc.MavenWebProject.model.Authors;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer>{

	
	//Spring boot paginate
}
