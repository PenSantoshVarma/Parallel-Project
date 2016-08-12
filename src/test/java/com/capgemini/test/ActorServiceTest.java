package com.capgemini.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.capgemini.dao.ActorDaoImplForList;
import com.capgemini.domain.Actor;
import com.capgemini.exceptions.DuplicateRecordFoundException;
import com.capgemini.exceptions.FieldEmptyException;
import com.capgemini.exceptions.NegativeInputException;
import com.capgemini.exceptions.RecordDoesNotExistsException;
import com.capgemini.service.ActorServiceImpl;
import com.capgemini.service.IActorService;

public class ActorServiceTest 
{
	private IActorService actorService;
	@Mock private ActorDaoImplForList actorDao;
	 
	@Before
		public void init()
		{
			MockitoAnnotations.initMocks(this);
			actorService=new ActorServiceImpl(actorDao);
		}
	
	@Test
	public void whenTheValidInfoIsGivenThenActorRecordMustBeSavedSuccessFully() throws FieldEmptyException, NegativeInputException, DuplicateRecordFoundException, RecordDoesNotExistsException {
		
		Actor actor=new Actor();
		actor.setFirstName("Santosh");
		actor.setLastName("Varma");
		List<Actor> actors=new ArrayList<Actor>();
		actors.add(actor);
		
		Map<String,String> actorDetails=new HashMap<String,String>();
		actorDetails.put("firstName","abc");
		actorDetails.put("lastName","xyz");
		

		Mockito.when(actorDao.AddActor(actor)).thenReturn(true);
		Mockito.when(actorDao.getAllActor()).thenReturn(actors);
		actorService.AddActor(actorDetails);
	}
	
	@Test(expected=com.capgemini.exceptions.RecordDoesNotExistsException.class)
	public void whenTheRecordDoesNotExistsInTheRemoveActorThenThrowRecordDoesNotExistsException() throws FieldEmptyException, DuplicateRecordFoundException, NegativeInputException, RecordDoesNotExistsException {
		
		Actor actor=new Actor();
		actor.setFirstName("Santosh");
		actor.setLastName("Varma");
		List<Actor> actors=new ArrayList<Actor>();
		actors.add(actor);
		
		Mockito.when(actorDao.RemoveActor(1)).thenThrow(new RecordDoesNotExistsException());
		actorService.RemoveActor(1);
	}

	@Test
	public void whenValidIdIsGivenInRemoveActorThenActorDetailsShouldBeRemovedSuccessFully() throws FieldEmptyException, NegativeInputException, DuplicateRecordFoundException, RecordDoesNotExistsException {
		
		Actor actor=new Actor();
		actor.setFirstName("Santosh");
		actor.setLastName("Varma");
		
		Mockito.when(actorDao.AddActor(actor)).thenReturn(true);
		Map<String, String> remove=new HashMap<String, String>();
		remove.put("firstName", "Santosh");
		remove.put("lastName","Varma");
	
		Mockito.when(actorDao.RemoveActor(1)).thenReturn(true);
		Mockito.when(actorDao.SearchActor(1)).thenReturn(actor);
		assertEquals(true,actorService.RemoveActor(1));
	}

	@Test(expected=com.capgemini.exceptions.RecordDoesNotExistsException.class)
	public void whenTheRecordDoesNotExistsInTheSearchActorThenThrowRecordDoesNotExistsException() throws FieldEmptyException, DuplicateRecordFoundException, NegativeInputException, RecordDoesNotExistsException {
		
		Actor actor=new Actor();
		actor.setFirstName("Santosh");
		actor.setLastName("Varma");
		Mockito.when(actorDao.AddActor(actor)).thenReturn(true);
		
		Map<String, String> Search=new HashMap<String,String>();
		Search.put("firstName", "abc");
		Search.put("lastName","xyz");
		
		Mockito.when(actorDao.SearchActor(1)).thenThrow(new RecordDoesNotExistsException());
		actorService.SearchActor(1);
	}

	@Test
	public void whenValidIdIsGivenInSearchActorThenActorDetailsShouldBeSearchedSuccessFully() throws FieldEmptyException, NegativeInputException, DuplicateRecordFoundException, RecordDoesNotExistsException {
		
		Actor actor=new Actor();
		actor.setFirstName("Santosh");
		actor.setLastName("Varma");
		Mockito.when(actorDao.AddActor(actor)).thenReturn(true);
		
		Map<String, String> Search=new HashMap<String, String>();
		Search.put("firstName", "abc");
		Search.put("lastName","xyz");
		
		
		Mockito.when(actorDao.SearchActor(1)).thenReturn(actor);
		assertEquals(actor,actorService.SearchActor(1));
	}

	@Test
	public void nullValueShouldBeReturnedIfNoActorDetailsExistsForGetAllActor() throws FieldEmptyException, NegativeInputException, DuplicateRecordFoundException {
		Mockito.when(actorDao.getAllActor()).thenReturn(null);
		assertEquals(null,actorService.getAllActor());
	}

	@Test
	public void actorsListShouldBeReturnedIfActorDetailsExistsForGetAllActor() throws FieldEmptyException, NegativeInputException, DuplicateRecordFoundException {
		Actor actor=new Actor();
		actor.setFirstName("Santosh");
		actor.setLastName("Varma");
		List<Actor> allActors = new ArrayList<Actor>();
		allActors.add(actor);
		
		Mockito.when(actorDao.getAllActor()).thenReturn(allActors);
		assertEquals(allActors,actorService.getAllActor());
	}
		
}
