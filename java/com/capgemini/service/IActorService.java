package com.capgemini.service;

import java.util.List;
import java.util.Map;

import com.capgemini.domain.Actor;

public interface IActorService {

	Actor AddActor(Map<String, String> actorDetails);

	Actor ModifyActor(Map<String, Object> actorDetails);

	boolean RemoveActor(int actor_id);

	Actor SearchActor(int actor_id);

	List<Actor> getAllActor();

}