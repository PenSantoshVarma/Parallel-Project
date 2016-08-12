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
public class Language 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="language_id",nullable=false)
	private int language_id;
	
	@Column(name="language_name",nullable=false)
	private String languageName;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL},mappedBy = "language")
	private Set<Film> films=new HashSet<Film>();
	
	public Language()
	{
		
	}
	
	public Language(String languageName) {
		this.languageName=languageName;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Language [language_id=" + language_id + ", languageName=" + languageName + "]";
	}
	
	
	
}
