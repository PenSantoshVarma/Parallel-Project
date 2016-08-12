package com.capgemini.domain;

import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
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

	public Set<Film> getFilm() {
		return film;
	}

	public void setFilm(Set<Film> film) {
		this.film = film;
	}

	@OneToMany(mappedBy="language")
	private Set<Film> film;

	@Override
	public String toString() {
		return "Language [language_id=" + language_id + ", languageName=" + languageName + "]";
	}
	
}
