package com.capgemini.domain;

//import java.math.int;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class Film 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="film_id",nullable=false)	
	private int film_id;
	
	@Column(name="title",nullable=false)
	private String title;
	
	@Column(name="description",nullable=false)
	private String description;
	 	
	@Column(name="release_date",nullable=false)
	private Date releaseDate;
	    
	@Column(name="rental_duration",nullable=false)
	private int rentalDuration;
	    
	@Column(name="rental_rate",nullable=false)
	private int rentalRate;
	    
	@Column(name="length",nullable=false)
	private int length;
	    
	@Column(name="replacement_cost",nullable=false)
	private int replacementCost;
	    
	@Column(name="rating",nullable=false)
	private int rating;
	    
	@Column(name="special_features",nullable=false)
	private String specialFeatures;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinColumn(name="language_id")
	private Language language;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinTable(name="film_category",joinColumns=@JoinColumn(name="film_id",referencedColumnName="film_id"),inverseJoinColumns=@JoinColumn(name="category_id",referencedColumnName="category_id"))
	private Category category;

	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id") , inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
	private List<Actor> actors = new ArrayList<Actor>();

	public Film()
	{
		
	}
	
	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public int getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(int rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(int replacementCost) {
		this.replacementCost = replacementCost;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", title=" + title + ", description=" + description + ", release_date="
				+ releaseDate + ", rental_duration=" + rentalDuration + ", rental_rate=" + rentalRate + ", length="
				+ length + ", replacementCost=" + replacementCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures + ", language=" + language
				+ ", category=" + category + ", actors=" + actors + "]";
	}


	
}
