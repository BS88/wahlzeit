/*
 * Copyright (c) 2017 by Benjamin Stone
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Logger;

import org.wahlzeit.annotation.PatternInstance;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.utils.CommonUsedAsserts;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;

@PatternInstance(

		name 		 = "Singelton",
		participants = {"Singelton"}
)
/**
 * 
 * The FootballManager provides access and manages FootballTypes and Footballs  
 * 
 * */
public class FootballManager extends ObjectManager {


	private static final Logger log = Logger.getLogger(FootballManager.class.getName());

	
	private static FootballManager 					m_instance;
	private static HashMap<String, Football> 		m_footballMem;
	private static HashMap<String, FootballType> 	m_footballTypeMem;
	
//-----------------Ctor--------------------------------------------------------
	
	private FootballManager () {
		super();
	}

//-----------------Public Methods----------------------------------------------
	
	/**
	 * 
	 * @methodtype get
	 * Returns the singelton instance of the FootballManager
	 * 
	 * */
	public static synchronized FootballManager getInstance() {
		
		if (m_instance == null)
			m_instance = new FootballManager();
		
		return m_instance;
	}

	/**
	 * 
	 * @methodtype initialization 
	 * Loads the Footballtypes and balls from the global Storage
	 * 
	 * */
	public void init() {
		//synchronization not needed, operation has no effect
		
		loadExistingFootballTypes();
		loadExistingFootballs();		
	}

	/**
	 * 
	 * @methodtype initialization 
	 * Loads the Footballs from the global Storage
	 * 
	 * */
	private void loadExistingFootballs() {
		
		ObjectifyService.run(new Work<Void>() {
			@Override
			public Void run() {
				Collection<Football> existingFootballs = new ArrayList<>();
				readObjects(existingFootballs, Football.class);

				for (Football ball : existingFootballs) {
						doAddFootball(ball);
						log.config(LogBuilder.createSystemMessage().addParameter("FootballType has been loaded",
								ball.getClass()).toString());
					}
				
				return null;
			}
		});
		log.info(LogBuilder.createSystemMessage().addMessage("loaded all stored Types").toString());
	}
	
	/**
	 * 
	 * @methodtype initialization
	 * Loads the Existing FootballTypes
	 * 
	 * */
	private void loadExistingFootballTypes() {
	
		ObjectifyService.run(new Work<Void>() {
			@Override
			public Void run() {
				Collection<FootballType> existingTypes = new ArrayList<>();
				readObjects(existingTypes, FootballType.class);

				for (FootballType type : existingTypes) {
						doAddFootballType(type);
						log.config(LogBuilder.createSystemMessage().addParameter("FootballType has been loaded",
								type.getClass()).toString());
					}
				
				return null;
			}
		});
		log.info(LogBuilder.createSystemMessage().addMessage("loaded all stored Types").toString());
	}

	/**
	 * 
	 * @methodtype factory method
	 * Adds a Football to local MemStorage and writes it to the global Storage
	 * 
	 * */
	private void doAddFootball(Football ball) {
				
		m_footballMem.put(ball.getName(), ball);
		super.writeObject(ball);
	}
	
	/**
	 * 
	 * @methodtype factory method
	 * Adds a FootballType to local MemStorage and writes it to the global Storage
	 * 
	 * */
	private void doAddFootballType(FootballType type) {
		
		m_footballTypeMem.put(type.getName(), type);
		super.writeObject(type);
	}
	
	/**
	 * 
	 * @methodtype factory method
	 * Creates a new Football
	 * 
	 * */
	public synchronized Football createFootball(String footballName, String footballType) {
		
		assertIsValidFootballName(footballName);
		assertIsValidType(footballType);

		if (m_footballMem.containsKey(footballName))
			return null;
		
		FootballType type = m_footballTypeMem.get(footballType);
		if (null == type)
			createFootballType(footballType, true);
		
				
		Football result = type.createFootball(footballName);
		doAddFootball(result);
		return result;
	}
	
	/**
	 * 
	 * @methodtype factory method
	 * Creates a new FootballType
	 * 
	 * */
	public synchronized FootballType createFootballType(String footballType, boolean checked) {
		
		if(!checked)
			assertIsValidType(footballType);
		
		if (m_footballTypeMem.containsKey(footballType))
			return null;
		
		FootballType result = new FootballType(footballType);
		doAddFootballType(result);
		
		return result;
	}
	
	/**
	 * @methodtype command
	 */
	public void saveFootballs() {
		updateObjects(m_footballMem.values());
	}
	
	/**
	 * @methodtype command
	 */
	public void saveFootballTypes() {
		updateObjects(m_footballTypeMem.values());
	}

//- ---------------Invariants, Assertions--------------------------------------	
	
	private void assertIsValidType(String name) {
		
		CommonUsedAsserts.assertIsNonNullObject(name, "The name of the Type must not be null");
		if (!(name.matches("[A-Z]{1}\\w+")))
			throw new IllegalArgumentException("Name of the Type must begin "
					+ "with a Capital Letter and there are only alphanumeric "
					+ "Characters and underscore allowed");
		
		return;
	}
	
	private void assertIsValidFootballName (String name) {
		
		CommonUsedAsserts.assertIsNonNullObject(name, "The name of the Football must not be null");
		if (!(name.matches("\\d{4}\\w+")))
			throw new IllegalArgumentException("Name of the Type must begin "
					+ "with 4 digits and there are only alphanumeric "
					+ "Characters and Underscore allowed");
		
		return;		
	}	
}
