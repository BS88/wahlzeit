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

/**
 * 	ADAP-CW 13 
 * 
 *  ===============Sequence of Methods which leads to a new Object=================================
 * 
 * 	new FootballPhoto Object
 * 
 * 	-> --FootballFactory--
 * 			
 * 		->	FootballFactory.getInstance() ------> returns the Singelton instance 
 * 			of the manager, which can create Objects
 * 
 * 			-> (Within FootballManager) createPhoto ()
 * 			
 * 				-> return new FootballPhoto()
 * 
 * 					
 * 
 * 
 * ================Six Tuple of Object Creation ===================================================
 * 
 * 		1. Delegation
 * 
 * 			---> delegating to FootballFactory 
 * 
 * 		2. Selection
 * 
 * 			---> by-subclassing
 * 
 * 		3. Configuration
 * 
 * 			---> No Configuration
 * 
 * 		4. Instantiation
 * 
 * 			---> in-code
 * 
 * 		5. Initialization
 * 
 * 			---> default
 * 
 * 		6. Building
 * 			
 * 			---> default
 * 
 * */


package org.wahlzeit.model;
import org.wahlzeit.annotation.PatternInstance;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;



/**
 * FootballPhoto represents a user-provided (uploaded) photo.
 */
@Entity
@Subclass(index = true)

@PatternInstance (	
		name		 ="Abstract Factory",
		participants = "ConcretProdukt"
)
public class FootballPhoto extends Photo
{

//--------------------------Ctors----------------------------------------------
	
	private Football m_football;
	
	/**
	 * @methodtype constructor
	 * Default
	 */
	
	public FootballPhoto() {
		
		super();	
	}
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public FootballPhoto(Football football) {
		
		this();
		m_football = football;
	}

	/**
	 * @methodtype constructor
	 * 
	 */
	public FootballPhoto(PhotoId id) {
		
		super(id);
	}
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public FootballPhoto(PhotoId id, Football football) {
		
		this(id);
		m_football = football;
	}

//-----------------Getter&Setter-----------------------------------------------
	
	/**
	 * @methodtype get
	 */
	public Football getFootball()
	{
		return m_football;
	}
	
	/**
	 * @methodtype set
	 * 
	 * */
	public void setProperties(Football football)
	{
		m_football = football;
	}
}
