package com.capgemini.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.capgemini.dao.ActorDaoImplForList;
import com.capgemini.dao.FilmDaoImplForList;
import com.capgemini.domain.Actor;
import com.capgemini.domain.Category;
import com.capgemini.domain.Film;
import com.capgemini.domain.Language;
import com.capgemini.exceptions.DuplicateRecordFoundException;
import com.capgemini.exceptions.FieldEmptyException;
import com.capgemini.exceptions.NegativeInputException;
import com.capgemini.exceptions.RecordDoesNotExistsException;
import com.capgemini.service.FilmServiceImpl;
import com.capgemini.service.IActorService;
import com.capgemini.service.IFilmService;

public class FilmServiceTest 
{
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private IFilmService filmService;
	@Mock private FilmDaoImplForList filmDao;
	private IActorService actorService;
	@Mock private ActorDaoImplForList actorDao;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		filmService = new FilmServiceImpl(filmDao,actorDao);
		
	}
	
	@Test(expected=com.capgemini.exceptions.FieldEmptyException.class)
	public void whenTheFieldIsEmptyThrowsFieldEmptyException() throws FieldEmptyException, NegativeInputException, DuplicateRecordFoundException, ParseException {
		
		Map <String,Object> filmDetails=new HashMap<String,Object>();
		filmDetails.put("description", "null");
		filmDetails.put("rating", 1);
		filmService.AddFilm(filmDetails);
	}

	@Test(expected=com.capgemini.exceptions.NegativeInputException.class)
	public void whenTheFieldValueIsNegativeThrowsNegativeInputException() throws FieldEmptyException, NegativeInputException, DuplicateRecordFoundException, ParseException {
		
		Map <String,Object> filmDetails=new HashMap<String,Object>();
		filmDetails.put("title", "Athadu");
		filmDetails.put("rating", -1);
		filmService.AddFilm(filmDetails);	
	}
	
	@Test
	public void whenTheValidInfoIsPassedItShouldBeStoredIntoDataBase() throws FieldEmptyException, NegativeInputException, DuplicateRecordFoundException, ParseException {
		
		Film film=new Film();
		film.setTitle("mb");
		film.setDescription("good");
		film.setReleaseDate((Date) dateFormat.parse("2017-04-14"));
		film.setRentalDuration(1);
		film.setRentalRate(2);
		film.setLength(3);
		film.setReplacementCost(4);
		film.setRating(5);
		film.setSpecialFeatures("hit");
		Category category=new Category();
		Language language=new Language();
		category.setCategoryName("message");
		language.setLanguageName("telugu");
		Actor actor=new Actor();
		actor.setFirstName("mahesh");
		actor.setLastName("babu");
			
		List<Actor> actors=new ArrayList<Actor>();
		actors.add(actor);
		film.setActors(actors);
		film.setCategory(category);
		film.setLanguage(language);
			
		Mockito.when(filmDao.AddFilm(film)).thenReturn(true);
		filmDao.AddFilm(film);
					
	}
	
	@Test(expected=com.capgemini.exceptions.NegativeInputException.class)
	public void whenIdIsNegativeInRemoveFilmThrowNegativeInputException() throws  NegativeInputException, DuplicateRecordFoundException, ParseException, RecordDoesNotExistsException, FieldEmptyException {

		filmService.RemoveFilm(-1);
	
	}
	
	@Test
	public void whenValidIdIsGivenInRemoveFilmThenFilmDetailsSholudRemovedSuccessfully() throws NegativeInputException, DuplicateRecordFoundException, ParseException, RecordDoesNotExistsException, FieldEmptyException {
		
		Mockito.when(filmDao.RemoveFilm(1)).thenReturn(true);
		assertEquals(true,filmService.RemoveFilm(1));
		
	}
	
	@Test(expected=com.capgemini.exceptions.NegativeInputException.class)
	public void whenIdIsNegativeInSearchFilmThrowNegativeInputException() throws  NegativeInputException, DuplicateRecordFoundException, ParseException, RecordDoesNotExistsException, FieldEmptyException {

		filmService.SearchFilm(-1);
	
	}
	
	@Test
	public void whenValidIdIsGivenInSearchFilmThenFilmDetailsSholudBeSearchedSuccessfully() throws NegativeInputException, DuplicateRecordFoundException, ParseException, RecordDoesNotExistsException, FieldEmptyException {
		
		Film film=new Film();
		film.setFilm_id(1);
		film.setTitle("mb");
		film.setDescription("good");
		film.setReleaseDate((Date) dateFormat.parse("2017-04-14"));
		film.setRentalDuration(1);
		film.setRentalRate(2);
		film.setLength(3);
		film.setReplacementCost(4);
		film.setRating(5);
		film.setSpecialFeatures("hit");
		Category category=new Category();
		Language language=new Language();
		category.setCategoryName("message");
		language.setLanguageName("telugu");
		Actor actor=new Actor();
		actor.setFirstName("mahesh");
		actor.setLastName("babu");
		List<Actor> actors=new ArrayList<Actor>();
		actors.add(actor);
		film.setActors(actors);
		film.setCategory(category);
		film.setLanguage(language);
		
		Mockito.when(filmDao.SearchFilm(1)).thenReturn(film);
		assertEquals(film,filmService.SearchFilm(1));
	}
	

	@Test
	public void nullValueShouldBeReturnedIfNoFilmDetailsExistsForGetAllActor() throws FieldEmptyException, NegativeInputException, DuplicateRecordFoundException {
		
		Mockito.when(filmDao.getAllFilm()).thenReturn(null);
		assertEquals(null,filmService.getAllFilm());
	}
	
	@Test
	public void actorsListShouldBeReturnedIfFilmDetailsExistsForGetAllActor() throws FieldEmptyException, NegativeInputException, DuplicateRecordFoundException, ParseException {
		
		Film film=new Film();
		film.setTitle("mb");
		film.setDescription("good");
		film.setReleaseDate((Date) dateFormat.parse("2017-04-14"));
		film.setRentalDuration(1);
		film.setRentalRate(2);
		film.setLength(3);
		film.setReplacementCost(4);
		film.setRating(5);
		film.setSpecialFeatures("hit");
		Category category=new Category();
		Language language=new Language();
		category.setCategoryName("message");
		language.setLanguageName("telugu");
		Actor actor=new Actor();
		actor.setFirstName("mahesh");
		actor.setLastName("babu");
		List<Actor> actors=new ArrayList<Actor>();
		actors.add(actor);
		film.setCategory(category);
		film.setLanguage(language);
		List<Film> films=new ArrayList<Film>();
		films.add(film);
		
		Mockito.when(filmDao.getAllFilm()).thenReturn(films);
		assertEquals(films,filmService.getAllFilm());
	}

}
