package com.capgemini.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.capgemini.domain.Film;

public interface IFilmService {

	Film AddFilm(Map<String, Object> filmDetails) throws ParseException;

	Film ModifyFilm(Map<String, Object> filmDetails);

	boolean RemoveFilm(int film_id);

	Film SearchFilm(int film_id);

	List<Film> getAllFilm();

}