package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.domain.Actor;
import com.capgemini.domain.Film;
import com.capgemini.exceptions.DuplicateRecordFoundException;
import com.capgemini.exceptions.RecordDoesNotExistsException;

public class ActorDaoImplForList implements IActorDao  
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");
	EntityManager em=emf.createEntityManager();
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#AddActor(com.capgemini.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#AddActor(com.capgemini.domain.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#AddActor(com.capgemini.domain.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#AddActor(com.capgemini.domain.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#AddActor(com.capgemini.domain.Actor)
	 */
	public boolean AddActor(Actor actor) throws RecordDoesNotExistsException, DuplicateRecordFoundException
	{
		if(!getAllActor().contains(actor))
		{
			em.getTransaction().begin();
			em.persist(actor);
			em.getTransaction().commit();
			return true;
		}
		else
			throw new DuplicateRecordFoundException();
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#ModifyActor(com.capgemini.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#ModifyActor(com.capgemini.domain.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#ModifyActor(com.capgemini.domain.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#ModifyActor(com.capgemini.domain.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#ModifyActor(com.capgemini.domain.Actor)
	 */
	public Actor ModifyActor(Actor actor)
	{
		em.getTransaction().begin();
		em.persist(actor);
		em.getTransaction().commit();
		return actor;
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#RemoveActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#RemoveActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#RemoveActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#RemoveActor(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#RemoveActor(int)
	 */
	public boolean RemoveActor(int actor_id) throws RecordDoesNotExistsException
	{
		Actor actor=findActor(actor_id);
		if(actor!=null)
		{
			em.getTransaction().begin();
			em.remove(actor);
			em.getTransaction().commit();
			return true;
		}
		else
			throw new RecordDoesNotExistsException();
	
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#SearchActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#SearchActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#SearchActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#SearchActor(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#SearchActor(int)
	 */
	public Actor SearchActor(int actor_id) throws RecordDoesNotExistsException
	{
		Actor actor=findActor(actor_id);
		if(actor!=null)
		{
			return actor;
		}
		else
			throw new RecordDoesNotExistsException();
		
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#getAllActor()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#getAllActor()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#getAllActor()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#getAllActor()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#getAllActor()
	 */
	public List<Actor> getAllActor()
	{
		TypedQuery<Actor> typedQuery= (TypedQuery<Actor>) em.createQuery("Select a from Actor a",Actor.class);
		return typedQuery.getResultList();
		
	}

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#findActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#findActor(short)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#findActor(int)
	 */
	public Actor findActor(int actor_id) 
	{
		return em.find(Actor.class, actor_id);
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#findActorByName(java.lang.String, java.lang.String)
	 */
	public Actor findActorByName(String firstName,String lastName)
	{
		TypedQuery<Actor> typedQuery=em.createQuery("Select a from Actor a where a.firstName='"+firstName+"' and a.lastName='"+lastName+"'",Actor.class);
		if(typedQuery.getResultList().size() > 0)
		{
			return typedQuery.getSingleResult();
		}
		return null;
		
	}
	
}
