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
import com.capgemini.exceptions.DuplicateRecordFoundException;
import com.capgemini.exceptions.FieldEmptyException;
import com.capgemini.exceptions.NegativeInputException;
import com.capgemini.dao.ActorDaoImplForList;
import com.capgemini.dao.FilmDaoImplForList;
import com.capgemini.dao.IActorDao;
import com.capgemini.dao.IFilmDao;

public class FilmServiceImpl implements IFilmService
{
	IFilmDao filmDao;
	IActorDao actorDao;
	public FilmServiceImpl()
	{
		filmDao=new FilmDaoImplForList();
		actorDao=new ActorDaoImplForList();
	}
	
	public FilmServiceImpl(IFilmDao filmDao,IActorDao actorDao)
	{
		this.filmDao=filmDao;
		this.actorDao=actorDao;
	}

	/* (non-Javadoc)
	 * @see com.capgemini.service.IFilmService#AddFilm(java.util.Map)
	 */
	public boolean AddFilm(Map<String, Object> filmDetails) throws ParseException, NegativeInputException, DuplicateRecordFoundException, FieldEmptyException 
	{
		Film film=new Film();
		if((Integer) filmDetails.get("rating")<0)
			throw new NegativeInputException();
		if((boolean) filmDetails.get("description").equals("null"))
			throw new FieldEmptyException();
		film.setTitle((String) filmDetails.get("title"));
		film.setDescription((String) filmDetails.get("description"));
		film.setReleaseDate((Date) filmDetails.get("releaseDate"));
		film.setRentalDuration((Integer) filmDetails.get("rentalDuration"));
		film.setRentalRate((Integer) filmDetails.get("rentalRate"));
		film.setLength((Integer) filmDetails.get("length"));
		film.setReplacementCost((Integer) filmDetails.get("replacementCost"));
		film.setRating((Integer) filmDetails.get("rating"));
		film.setSpecialFeatures((String) filmDetails.get("specialFeatures"));
		
		Language language=filmDao.findLanguageByName((String) filmDetails.get("languageName"));
		if(language==null)
		{
			language=new Language((String) filmDetails.get("languageName"));
		}
		film.setLanguage(language);
		
		Category category=filmDao.findCategoryByName((String) filmDetails.get("categoryName"));
		if(category==null)
		{
			category=new Category((String) filmDetails.get("categoryName"));
		}
		film.setCategory(category);
		
		List<Actor> actors=actorDao.getAllActor();
		for(int i=0;i<((List<Film>) filmDetails.get("actors")).size();i++)
		{
			Actor actor=new Actor();
			actor.setFirstName((String) ((Map<String, Object>) ((List<Film>) filmDetails.get("actors")).get(i)).get("firstName"));
			actor.setLastName((String) ((Map<String, Object>) ((List<Film>) filmDetails.get("actors")).get(i)).get("lastName"));
			
			if(!actors.contains(actor))
			{
				film.getActors().add(actor);
			}
			else
			{
				film.getActors().add(actorDao.findActorByName(actor.getFirstName(),actor.getLastName()));
			}
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
			if(filmDetails.get("title")!=null)
			{
				film.setTitle((String) filmDetails.get("title"));
				return filmDao.ModifyFilm(film);
			}
			else if(filmDetails.get("description")!=null)
			{
				film.setDescription((String) filmDetails.get("description"));
				return filmDao.ModifyFilm(film);
			}
			else if(filmDetails.get("releaseDate")!=null)
			{
				film.setReleaseDate((Date) filmDetails.get("releaseDate"));
				return filmDao.ModifyFilm(film);
			}
			else if(filmDetails.get("rentalDuration")!=null)
			{
				film.setRentalDuration((Integer) filmDetails.get("rentalDuration"));
				return filmDao.ModifyFilm(film);
			}
			else if(filmDetails.get("rentalRate")!=null)
			{
				film.setRentalRate((Integer) filmDetails.get("rentalRate"));
				return filmDao.ModifyFilm(film);
			}
			else if(filmDetails.get("length")!=null)
			{
				film.setLength((Integer) filmDetails.get("length"));
				return filmDao.ModifyFilm(film);
			}
			else if(filmDetails.get("replacementCost")!=null)
			{
				film.setReplacementCost((Integer) filmDetails.get("replacementCost"));
				return filmDao.ModifyFilm(film);
			}
			else if(filmDetails.get("rating")!=null)
			{
				film.setRating((Integer) filmDetails.get("rating"));
				return filmDao.ModifyFilm(film);
			}
			else if(filmDetails.get("specialFeatures")!=null)
			{
				film.setSpecialFeatures((String) filmDetails.get("specialFeatures"));
				return filmDao.ModifyFilm(film);
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
	public boolean RemoveFilm(int film_id) throws NegativeInputException 
	{
		if(film_id<0)
			throw new NegativeInputException();
		return filmDao.RemoveFilm(film_id);
		
	}

	/* (non-Javadoc)
	 * @see com.capgemini.service.IFilmService#SearchFilm(short)
	 */
	public Film SearchFilm(int film_id) throws NegativeInputException
	{
		if(film_id<0)
			throw new NegativeInputException();
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
