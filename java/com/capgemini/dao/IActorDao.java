package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.Actor;

public interface IActorDao {

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#AddActor(com.capgemini.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#AddActor(com.capgemini.domain.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#AddActor(com.capgemini.domain.Actor)
	 */
	Actor AddActor(Actor actor);

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#ModifyActor(com.capgemini.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#ModifyActor(com.capgemini.domain.Actor)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#ModifyActor(com.capgemini.domain.Actor)
	 */
	Actor ModifyActor(Actor actor);

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#RemoveActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#RemoveActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#RemoveActor(int)
	 */
	boolean RemoveActor(int actor_id);

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#SearchActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#SearchActor(int)
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#SearchActor(int)
	 */
	Actor SearchActor(int actor_id);

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#getAllActor()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#getAllActor()
	 */
	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#getAllActor()
	 */
	List<Actor> getAllActor();

	/* (non-Javadoc)
	 * @see com.capgemini.dao.IActorDao#findActor(int)
	 */
	Actor findActor(int actor_id);

}