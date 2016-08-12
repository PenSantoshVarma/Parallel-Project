package com.capgemini.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.capgemini.domain.Actor;
import com.capgemini.domain.Film;
import com.capgemini.exceptions.DuplicateRecordFoundException;
import com.capgemini.exceptions.FieldEmptyException;
import com.capgemini.exceptions.NegativeInputException;
import com.capgemini.exceptions.RecordDoesNotExistsException;
import com.capgemini.service.ActorServiceImpl;
import com.capgemini.service.FilmServiceImpl;
import com.capgemini.service.IActorService;
import com.capgemini.service.IFilmService;

public class UserInteraction 
{
	IFilmService filmService;
	IActorService actorService;
	Scanner sc=new Scanner(System.in);
	
	public UserInteraction()
	{
		filmService=new FilmServiceImpl();
		actorService=new ActorServiceImpl();
	}

	public boolean AddFilm() throws ParseException, NegativeInputException, DuplicateRecordFoundException, FieldEmptyException 
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		Map<String,Object> filmDetails=new HashMap<String,Object>();
		List actors=new ArrayList();
		
		System.out.println("Enter title");
		filmDetails.put("title", sc.next());
		System.out.println("Enter description");
		filmDetails.put("description", sc.next());
		System.out.println("Enter release date");
		filmDetails.put("releaseDate", dateFormat.parse(sc.next()));
		System.out.println("Enter rental duration");
		filmDetails.put("rentalDuration", sc.nextInt());
		System.out.println("Enter rental rate");
		filmDetails.put("rentalRate", sc.nextInt());
		System.out.println("Enter length of the movie");
		filmDetails.put("length", sc.nextInt());
		System.out.println("Enter replacement cost");
		filmDetails.put("replacementCost", sc.nextInt());
		System.out.println("Enter rating");
		filmDetails.put("rating", sc.nextInt());
		System.out.println("Enter special features");
		filmDetails.put("specialFeatures", sc.next());
		
		System.out.println("Enter the language name");
		filmDetails.put("languageName", sc.next());
		
		System.out.println("Enter the category name");
		filmDetails.put("categoryName", sc.next());
		
		System.out.println("Enter numberOfActors");
		int numberOfActors=sc.nextInt();
		
		for(int i=1;i<=numberOfActors;i++)
		{
			Map<String, String> actorDetails=new HashMap<String, String>();
			System.out.println("Enter the actor first name");
			actorDetails.put("firstName", sc.next());
			System.out.println("Enter the actor last name");
			actorDetails.put("lastName", sc.next());
			actors.add(actorDetails);
		}
		
		filmDetails.put("actors", actors);
		return filmService.AddFilm(filmDetails);
		
	}

	public Film ModifyFilm() throws ParseException, NegativeInputException 
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		//List actors=new ArrayList();
		Map<String,Object> filmDetails=new HashMap<String,Object>();
		System.out.println("Enter the film_id to modify");
		filmDetails.put("film_id", sc.nextInt());
		
		Film film=filmService.SearchFilm((Integer) filmDetails.get("film_id"));
		
		if(film!=null)
		{
			System.out.println("Enter choice of field to modify:1.title 2.description 3.releaseDate 4.rentalDuration 5.rentalRate 6.length 7.replacementCost 8.rating 9.specialFeatures");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:System.out.println("Enter title");
						filmDetails.put("title", sc.next());
						break;
				case 2:System.out.println("Enter description");
						filmDetails.put("description", sc.next());
						break;
				case 3:System.out.println("Enter release date");
						filmDetails.put("releaseDate", dateFormat.parse(sc.next()));
						break;
				case 4:System.out.println("Enter rental duration");
						filmDetails.put("rentalDuration", sc.nextInt());
						break;
				case 5:System.out.println("Enter rental rate");
						filmDetails.put("rentalRate", sc.nextInt());
						break;
				case 6:System.out.println("Enter length of the movie");
						filmDetails.put("length", sc.nextInt());
						break;
				case 7:System.out.println("Enter replacement cost");
						filmDetails.put("replacementCost", sc.nextInt());
						break;
				case 8:System.out.println("Enter rating");
						filmDetails.put("rating", sc.nextInt());
						break;
				case 9:System.out.println("Enter special features");
						filmDetails.put("specialFeatures", sc.next());
						break;
				
			}
			return filmService.ModifyFilm(filmDetails);
		}
		else
		{
			return null;
		}
				
	}
	
	public void RemoveFilm() throws NegativeInputException 
	{
		System.out.println("Enter the film_id to remove");
		int film_id=sc.nextInt();
		Film film=filmService.SearchFilm(film_id);
		if(film !=null)
		{
			filmService.RemoveFilm(film_id);
			System.out.println("Film removed successfully");
		}
		else
		{
			System.out.println("Film not found");
		}
		
	}

	public void SearchFilm() throws NegativeInputException 
	{
		System.out.println("Enter the film_id to search");
		int film_id=sc.nextInt();
		Film film=filmService.SearchFilm(film_id);
		if(film !=null)
		{
			System.out.println("Film found "+film);
		}
		else
		{
			System.out.println("Film not found");
		}
		
	}

	public void getAllFilm() 
	{
		List<Film> films=filmService.getAllFilm();
		System.out.println("All films details are "+films);
		
	}

	public boolean AddActor() throws RecordDoesNotExistsException, DuplicateRecordFoundException 
	{
		Actor actor=new Actor();
		Map<String, String> actorDetails=new HashMap<String, String>();
		System.out.println("Enter the actor's first_name");
		actorDetails.put("firstName", sc.next());
		System.out.println("Enter the actor's last_name");
		actorDetails.put("lastName", sc.next());
		System.out.println("Actor added successfully");
		return actorService.AddActor(actorDetails);
		
	}

	public Actor ModifyActor() throws RecordDoesNotExistsException 
	{
		Map<String, Object> actorDetails=new HashMap<String, Object>();
		System.out.println("Enter the actor_id to modify");
		actorDetails.put("actor_id", sc.nextInt());
		
		Actor actor=actorService.SearchActor((Integer) actorDetails.get("actor_id"));
		if(actor!=null)
		{
			System.out.println("Enter the actor's first_name");
			actorDetails.put("firstName", sc.next());
			System.out.println("Enter the actor's last_name");
			actorDetails.put("lastName", sc.next());
			System.out.println("Actor modified successfully");
			return actorService.ModifyActor(actorDetails);
		}
		else
		{
			return null;
		}
		
	}

	public void RemoveActor() throws RecordDoesNotExistsException 
	{
		System.out.println("Enter the actor_id to remove");
		int actor_id=sc.nextInt();
		Actor actor=actorService.SearchActor(actor_id);
		if(actor !=null)
		{
			actorService.RemoveActor(actor_id);
			System.out.println("Actor removed successfully");
		}
		else
		{
			System.out.println("Actor Not Found");
		}
		
	}

	public void SearchActor() throws RecordDoesNotExistsException 
	{
		System.out.println("Enter the actor_id to search");
		int actor_id=sc.nextInt();
		Actor actor=actorService.SearchActor(actor_id);
		if(actor !=null)
		{
			System.out.println("Found "+actor);
		}
		else
		{
			System.out.println("Actor not found");
		}
		
	}

	public void getAllActor() 
	{
		List<Actor> actors= actorService.getAllActor();
		System.out.println("All actors details are "+actors);
		
	}

}
