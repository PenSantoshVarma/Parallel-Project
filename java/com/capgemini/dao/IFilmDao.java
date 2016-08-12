package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.Film;

public interface IFilmDao {

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#AddFilm(com.capgemini.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#AddFilm(com.capgemini.domain.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#AddFilm(com.capgemini.domain.Film)
	 */
	Film AddFilm(Film film);

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#ModifyFilm(com.capgemini.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#ModifyFilm(com.capgemini.domain.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#ModifyFilm(com.capgemini.domain.Film)
	 */
	Film ModifyFilm(Film film);

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#RemoveFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#RemoveFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#RemoveFilm(short)
	 */
	boolean RemoveFilm(int film_id);

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#SearchFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#SearchFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#SearchFilm(short)
	 */
	Film SearchFilm(int film_id);

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#getAllFilm()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#getAllFilm()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#getAllFilm()
	 */
	List<Film> getAllFilm();

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#findFilm(short)
	 */
	Film findFilm(int film_id);

}