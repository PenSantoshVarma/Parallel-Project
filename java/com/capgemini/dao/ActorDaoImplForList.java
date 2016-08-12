package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.domain.Actor;
import com.capgemini.domain.Film;

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
	public Actor AddActor(Actor actor)
	{
		em.getTransaction().begin();
		em.persist(actor);
		em.getTransaction().commit();
		return actor;
		
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
	public boolean RemoveActor(int actor_id)
	{
		Actor actor=findActor(actor_id);
		if(actor!=null)
		{
			em.getTransaction().begin();
			em.remove(actor);
			em.getTransaction().commit();
			return true;
		}
		return false;
		
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
	public Actor SearchActor(int actor_id)
	{
		Actor actor=findActor(actor_id);
		if(actor!=null)
		{
			return actor;
		}
		return null;
		
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
	public List<Actor> getAllActor()
	{
		TypedQuery<Actor> typedQuery= (TypedQuery<Actor>) em.createQuery("Select a from Actor a");
		return typedQuery.getResultList();
		
	}

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#findActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#findActor(short)
	 */
	public Actor findActor(int actor_id) 
	{
		return em.find(Actor.class, actor_id);
	}
}
