package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.domain.Actor;
import com.capgemini.service.ActorServiceImpl;
import com.capgemini.service.IActorService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ViewAllActors extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		response.setContentType("application/json");

		IActorService actorService=new ActorServiceImpl();
		List<Actor> actors=actorService.getAllActor();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Actor.class, new ActorAdapter()).create();
		
		String myJsonActorObj= gson.toJson(actors);
		out.println(myJsonActorObj);

	}

}

class ActorAdapter implements JsonSerializer<Actor> {

	public JsonElement serialize(Actor actor, Type type, JsonSerializationContext jsc) {
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("actor_id", actor.getActor_id());
		jsonObject.addProperty("firstName", actor.getFirstName());
		jsonObject.addProperty("lastName", actor.getLastName());
		
		return jsonObject;
		
	}

}