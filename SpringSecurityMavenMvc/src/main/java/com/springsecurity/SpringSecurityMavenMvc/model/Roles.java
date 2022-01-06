package com.springsecurity.SpringSecurityMavenMvc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Roles {
	@Id
	@Column(name ="role_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleId;

	@Column(name = "role_name")
	private String name;
	

	@ManyToMany(mappedBy = "roles")
    private Set<User> users;

	
	public Roles() {
	}


	public Roles(int roleId, String name, Set<User> users) {
		this.roleId = roleId;
		this.name = name;
		this.users = users;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", name=" + name + ", users=" + users + "]";
	}

}
