package com.capgemini.service;

import java.util.List;
import java.util.Map;

import com.capgemini.domain.Actor;
import com.capgemini.exceptions.DuplicateRecordFoundException;
import com.capgemini.exceptions.RecordDoesNotExistsException;

public interface IActorService {

	boolean AddActor(Map<String, String> actorDetails) throws RecordDoesNotExistsException, DuplicateRecordFoundException;

	Actor ModifyActor(Map<String, Object> actorDetails) throws RecordDoesNotExistsException;

	boolean RemoveActor(int actor_id) throws RecordDoesNotExistsException;

	Actor SearchActor(int actor_id) throws RecordDoesNotExistsException;

	List<Actor> getAllActor();

}