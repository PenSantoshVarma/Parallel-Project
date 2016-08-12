package com.capgemini.service;

import java.util.List;
import java.util.Map;

import com.capgemini.domain.Actor;
import com.capgemini.domain.Film;
import com.capgemini.exceptions.DuplicateRecordFoundException;
import com.capgemini.exceptions.RecordDoesNotExistsException;
import com.capgemini.dao.ActorDaoImplForList;
import com.capgemini.dao.IActorDao;

public class ActorServiceImpl implements IActorService
{
	IActorDao actorDao;
	
	public ActorServiceImpl()
	{
		actorDao=new ActorDaoImplForList();
		
	}
	
	public ActorServiceImpl(IActorDao actorDao)
	{
		this.actorDao=actorDao;
	}
	

	/* (non-Javadoc)
	 * @see com.capgemini.service.IActorService#AddActor(java.util.Map)
	 */
	public boolean AddActor(Map<String, String> actorDetails) throws RecordDoesNotExistsException, DuplicateRecordFoundException
	{
		Actor actor=new Actor();
		actor.setFirstName((String) actorDetails.get("firstName"));
		actor.setLastName((String) actorDetails.get("lastName"));
		return true;
	
	}

	/* (non-Javadoc)
	 * @see com.capgemini.service.IActorService#ModifyActor(java.util.Map)
	 */
	public Actor ModifyActor(Map<String, Object> actorDetails) throws RecordDoesNotExistsException 
	{
		Actor actor=actorDao.SearchActor((Integer) actorDetails.get("actor_id"));
		if(actor!=null)
		{
			actor.setFirstName((String) actorDetails.get("firstName"));
			actor.setLastName((String) actorDetails.get("lastName"));
			return actorDao.ModifyActor(actor);
		}
		else
		{
			return null;
		}
	
	}

	/* (non-Javadoc)
	 * @see com.capgemini.service.IActorService#RemoveActor(int)
	 */
	public boolean RemoveActor(int actor_id) throws RecordDoesNotExistsException 
	{
		return actorDao.RemoveActor(actor_id);
		
	}

	/* (non-Javadoc)
	 * @see com.capgemini.service.IActorService#SearchActor(int)
	 */
	public Actor SearchActor(int actor_id) throws RecordDoesNotExistsException 
	{
		return actorDao.SearchActor(actor_id);
		
	}

	/* (non-Javadoc)
	 * @see com.capgemini.service.IActorService#getAllActor()
	 */
	public List<Actor> getAllActor() 
	{
		return actorDao.getAllActor();
		
	}

}
