package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.Actor;
import com.capgemini.exceptions.DuplicateRecordFoundException;
import com.capgemini.exceptions.RecordDoesNotExistsException;

public interface IActorDao {

	boolean AddActor(Actor actor) throws RecordDoesNotExistsException, DuplicateRecordFoundException;

	Actor ModifyActor(Actor actor);

	boolean RemoveActor(int actor_id) throws RecordDoesNotExistsException;

	Actor SearchActor(int actor_id) throws RecordDoesNotExistsException;

	List<Actor> getAllActor();

	Actor findActor(int actor_id);

	Actor findActorByName(String firstName, String lastName);

}