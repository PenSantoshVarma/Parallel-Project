package com.capgemini.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="category_id",nullable=false)
	private int category_id;
	
	@Column(name="category_name",nullable=false)
	private String categoryName;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL},mappedBy="category")
	private Set<Film> films=new HashSet<Film>();
	
	public Category()
	{
		
	}
	
	public Category(String categoryName) {
		this.categoryName=categoryName;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", categoryName=" + categoryName + "]";
	}
	
	
	
}
