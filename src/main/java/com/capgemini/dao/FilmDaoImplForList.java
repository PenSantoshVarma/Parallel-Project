package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.domain.Category;
import com.capgemini.domain.Film;
import com.capgemini.domain.Language;
import com.capgemini.exceptions.DuplicateRecordFoundException;

public class FilmDaoImplForList implements IFilmDao    
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");
	EntityManager em=emf.createEntityManager();
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#AddFilm(com.capgemini.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#AddFilm(com.capgemini.domain.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#AddFilm(com.capgemini.domain.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#AddFilm(com.capgemini.domain.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#AddFilm(com.capgemini.domain.Film)
	 */
	public boolean AddFilm(Film film) throws DuplicateRecordFoundException
	{
		if(!getAllFilm().contains(film))
		{
			em.getTransaction().begin();
			em.persist(film);
			em.getTransaction().commit();
			return true;
		}
		throw new DuplicateRecordFoundException();
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#ModifyFilm(com.capgemini.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#ModifyFilm(com.capgemini.domain.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#ModifyFilm(com.capgemini.domain.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#ModifyFilm(com.capgemini.domain.Film)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#ModifyFilm(com.capgemini.domain.Film)
	 */
	public Film ModifyFilm(Film film)
	{
		em.getTransaction().begin();
		em.persist(film);
		em.getTransaction().commit();
		return film;
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#RemoveFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#RemoveFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#RemoveFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#RemoveFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#RemoveFilm(int)
	 */
	public boolean RemoveFilm(int film_id)
	{
		Film film=findFilm(film_id);
		if(film!=null)
		{
			em.getTransaction().begin();
			em.remove(film);
			em.getTransaction().commit();
			return true;
		}
		return false;
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#SearchFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#SearchFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#SearchFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#SearchFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#SearchFilm(int)
	 */
	public Film SearchFilm(int film_id)
	{
		Film film=findFilm(film_id);
		if(film!=null)
		{
			return film;
		}
		return null;
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#getAllFilm()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#getAllFilm()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#getAllFilm()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#getAllFilm()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#getAllFilm()
	 */
	public List<Film> getAllFilm()
	{
		TypedQuery<Film> typedQuery= (TypedQuery<Film>) em.createQuery("Select f from Film f");
		return typedQuery.getResultList();
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#findFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#findFilm(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#findFilm(int)
	 */
	public Film findFilm(int film_id)
	{
		return em.find(Film.class, film_id);
	}

	/*public boolean RemoveFilm(Object film_id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Film SearchFilm(Object film_id) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*public Film findFilm(Object object) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#findLanguageByName(java.lang.String)
	 */
	public Language findLanguageByName(String languageName)
	{
		TypedQuery<Language> typedQuery = em.createQuery("Select l from Language l where l.languageName='"+languageName+"' ",Language.class);
		
		if(typedQuery.getResultList().size() > 0)
		{
			return typedQuery.getSingleResult();
		}
		return null;
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IFilmDao#findCategoryByName(java.lang.String)
	 */
	public Category findCategoryByName(String categoryName)
	{
		TypedQuery<Category> typedQuery = em.createQuery("Select c from Category c where c.categoryName='"+categoryName+"' ",Category.class);
		
		if(typedQuery.getResultList().size() > 0)
		{
			return typedQuery.getSingleResult();
		}
		return null;
		
	}

}
