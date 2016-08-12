package com.capgemini.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.capgemini.domain.Film;
import com.capgemini.exceptions.DuplicateRecordFoundException;
import com.capgemini.exceptions.FieldEmptyException;
import com.capgemini.exceptions.NegativeInputException;

public interface IFilmService {

	boolean AddFilm(Map<String, Object> filmDetails) throws ParseException, NegativeInputException, DuplicateRecordFoundException, FieldEmptyException;

	Film ModifyFilm(Map<String, Object> filmDetails);

	boolean RemoveFilm(int film_id) throws NegativeInputException;

	Film SearchFilm(int film_id) throws NegativeInputException;

	List<Film> getAllFilm();

}