package com.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.domain.Film;
import com.capgemini.service.FilmServiceImpl;
import com.capgemini.service.IFilmService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ViewAllFilms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   		PrintWriter out=response.getWriter();
   		response.setContentType("application/json");
   		
   		IFilmService filmService=new FilmServiceImpl();
   		List<Film> films=filmService.getAllFilm();
   		
   		GsonBuilder gsonBuilder = new GsonBuilder();
   		Gson gson = gsonBuilder.registerTypeAdapter(Film.class, new FilmAdapter()).create();
   		
   		String myJsonFilmObj=gson.toJson(films);
   		out.println(myJsonFilmObj);
   		
	}

}

class FilmAdapter implements JsonSerializer<Film> {
	
	public JsonElement serialize(Film film,Type type, JsonSerializationContext jsc) {
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("film_id", film.getFilm_id());
		jsonObject.addProperty("title", film.getTitle());
		jsonObject.addProperty("description", film.getDescription());
		jsonObject.addProperty("releaseDate", film.getReleaseDate().toString());
		jsonObject.addProperty("rentalDuration", film.getRentalDuration());
		jsonObject.addProperty("rentalRate", film.getRentalRate());
		jsonObject.addProperty("length", film.getLength());
		jsonObject.addProperty("replacementCost", film.getReplacementCost());
		jsonObject.addProperty("rating", film.getRating());
		jsonObject.addProperty("specialFeatures", film.getSpecialFeatures());
	
		return jsonObject;
		
	}
}
