package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.Category;
import com.capgemini.domain.Film;
import com.capgemini.domain.Language;
import com.capgemini.exceptions.DuplicateRecordFoundException;

public interface IFilmDao {

	boolean AddFilm(Film film) throws DuplicateRecordFoundException;

	Film ModifyFilm(Film film);

	boolean RemoveFilm(int film_id);

	Film SearchFilm(int film_id);

	List<Film> getAllFilm();

	Film findFilm(int film_id);

	Language findLanguageByName(String languageName);

	Category findCategoryByName(String categoryName);

}