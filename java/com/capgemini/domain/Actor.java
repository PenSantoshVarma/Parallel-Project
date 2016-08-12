package com.capgemini.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="actor_id",nullable=false)
	private int actor_id;
	    
	@Column(name="first_name",nullable=false)
	private String firstName;
	    
	@Column(name="last_name",nullable=false)
	private String lastName;
	    
	@ManyToMany(fetch = FetchType.LAZY,mappedBy="actors")
	private Set<Film> films=new HashSet<Film>();

	public Actor()
	{
		
	}
	
	public Actor(String first_name, String last_name) {
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public int getActor_id() {
		return actor_id;
	}

	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Actor [actor_id=" + actor_id + ", first_name=" + firstName + ", last_name=" + lastName + "]";
			
	}

	

}
