package com.capgemini.service;

import java.math.BigDecimal;
import java.util.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.capgemini.domain.Actor;
import com.capgemini.domain.Category;
import com.capgemini.domain.Film;
import com.capgemini.domain.Language;
import com.capgemini.dao.FilmDaoImplForList;
import com.capgemini.dao.IFilmDao;

public class FilmServiceImpl implements IFilmService
{
	IFilmDao filmDao;
	public FilmServiceImpl()
	{
		filmDao=new FilmDaoImplForList();
		
	}

	/* (non-Javadoc)
	 * @see com.capgemini.service.IFilmService#AddFilm(java.util.Map)
	 */
	public Film AddFilm(Map<String, Object> filmDetails) throws ParseException 
	{
		Film film=new Film();
		Language language=new Language();
		Category category=new Category();
		film.setTitle((String) filmDetails.get("title"));
		film.setDescription((String) filmDetails.get("description"));
		film.setReleaseDate((Date) filmDetails.get("releaseDate"));
		film.setRentalDuration((Integer) filmDetails.get("rentalDuration"));
		film.setRentalRate((Integer) filmDetails.get("rentalRate"));
		film.setLength((Integer) filmDetails.get("length"));
		film.setReplacementCost((Integer) filmDetails.get("replacementCost"));
		film.setRating((Integer) filmDetails.get("rating"));
		film.setSpecialFeatures((String) filmDetails.get("specialFeatures"));
		
		language.setLanguageName((String) filmDetails.get("languageName"));
		film.setLanguage(language);
		
		category.setCategoryName((String) filmDetails.get("categoryName"));
		film.setCategory(category);
		
		for(int i=0;i<((List<Film>) filmDetails.get("actors")).size();i++)
		{
			Actor actor=new Actor();
			actor.setFirstName((String) ((Map<String, Object>) ((List<Film>) filmDetails.get("actors")).get(i)).get("firstName"));
			actor.setLastName((String) ((Map<String, Object>) ((List<Film>) filmDetails.get("actors")).get(i)).get("lastName"));
			film.getActors().add(actor);
		}
		return filmDao.AddFilm(film);
	}

	/* (non-Javadoc)
	 * @see com.capgemini.service.IFilmService#ModifyFilm(java.util.Map)
	 */
	public Film ModifyFilm(Map<String, Object> filmDetails) 
	{
		Film film=filmDao.SearchFilm((Integer) filmDetails.get("film_id"));
		
		if(film!=null)
		{
			Language language=new Language();
			Category category=new Category();
			film.setTitle((String) filmDetails.get("title"));
			film.setDescription((String) filmDetails.get("description"));
			film.setReleaseDate((Date) filmDetails.get("releaseDate"));
			film.setRentalDuration((Integer) filmDetails.get("rentalDuration"));
			film.setRentalRate((Integer) filmDetails.get("rentalRate"));
			film.setLength((Integer) filmDetails.get("length"));
			film.setReplacementCost((Integer) filmDetails.get("replacementCost"));
			film.setRating((Integer) filmDetails.get("rating"));
			film.setSpecialFeatures((String) filmDetails.get("specialFeatures"));
			
			language.setLanguageName((String) filmDetails.get("languageName"));
			film.setLanguage(language);
			
			category.setCategoryName((String) filmDetails.get("categoryName"));
			film.setCategory(category);
			
			for(int i=0;i<((List<Film>) filmDetails.get("actors")).size();i++)
			{
				Actor actor=new Actor();
				actor.setFirstName((String) ((Map<String, Object>) ((List<Film>) filmDetails.get("actors")).get(i)).get("firstName"));
				actor.setLastName((String) ((Map<String, Object>) ((List<Film>) filmDetails.get("actors")).get(i)).get("lastName"));
				film.getActors().add(actor);
			}
			return filmDao.ModifyFilm(film);
		}
		else
		{
			return null;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.capgemini.service.IFilmService#RemoveFilm(short)
	 */
	public boolean RemoveFilm(int film_id) 
	{
		return filmDao.RemoveFilm(film_id);
		
	}

	/* (non-Javadoc)
	 * @see com.capgemini.service.IFilmService#SearchFilm(short)
	 */
	public Film SearchFilm(int film_id) 
	{
		return filmDao.SearchFilm(film_id);
		
	}

	/* (non-Javadoc)
	 * @see com.capgemini.service.IFilmService#getAllFilm()
	 */
	public List<Film> getAllFilm() 
	{
		return filmDao.getAllFilm();
		
	}	

}
