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
 *  new Football Object
 * 
 * 	-> --FootballManager--
 * 			
 * 		->	FootballManager.getInstance() ------> returns the Singelton instance 
 * 			of the manager, which can create Objects
 * 
 * 			-> (Within FootballManager) createFootball (String footballName, String footballType)
 * 			
 * 				-> type t = TypesMemory.getType(footballType)
 * 						
 * 					->	Football new  = t.createFootball(footballName) 
 * 				
 * 						-> (Within FootballType) Football createFootball (String name)
 * 						
 * 							-> return new Football(FootballType type , String name)
 * 
 * 
 * ================Six Tuple of Object Creation ===================================================
 * 
 * 		1. Delegation
 * 
 * 			---> delegating to FootballManager and then to FootballType
 * 
 * 		2. Selection
 * 
 * 			---> on the spot
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
 * 			---> by-fixed-signature
 * 
 * 		6. Building
 * 			
 * 			---> default
 * 
 * */

package org.wahlzeit.model;

import org.wahlzeit.annotation.PatternInstance;
import org.wahlzeit.services.DataObject;
import org.wahlzeit.utils.CommonUsedAsserts;

@PatternInstance (
	name= "Type Object",
	participants = {"Object"}
)
	
/**
 * 
 * The Football class represents a the TypeTraits of a real Football  
 * */
public class Football extends DataObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FootballType	m_type;
	
	private double 			m_diameter; 
	private double			m_weight  ;
	
	private final String 	m_name;
	private String 			m_manufacturer;
	private String 			m_marketYear;
	
	
//-----------------Ctor's------------------------------------------------------
	//forbid empty init
	private Football() {
		
		m_name = null;
	}
	
	public Football (FootballType type,String name, double diameter, double weight,
			String manufacturer, String marketYear) {
		
		assertClassInvariants();
		
		m_type 			= type;
		m_name 			= name;
		m_diameter 		= diameter;
		m_weight 		= weight;
		m_manufacturer 	= manufacturer;
		m_marketYear	= marketYear;
			
		assertClassInvariants();
	}
	
	public Football (FootballType type, String name) {
		
		this(type,name, 0,0,"", "");
	}
	
	public Football(FootballType type, String name, double diameter,
			double  weight) {
		
		this(type,name,diameter, weight, "", "");
	}
	public Football(FootballType type,String name, double diameter, double weight, 
			String manufacturer) {
	
		this(type,name,diameter, weight, null,null);
	}
		
	public Football(FootballType type,String name, String manufacturer, String marketYear) {
		
		this(type,name,0,0,manufacturer,marketYear);
	}
	
//-----------------Getter------------------------------------------------------	
	
	/**
	 * @methodtype get
	 * Returns the Name of the Ball *UNIQUE*
	 * */
	public String getName() {
		
		return m_name;
	}
	
	/**
	 * @methodtype get
	 * Returns the Name of the Diameter of the Ball
	 * */
	public double getDiameter() {
		
		return m_diameter;
	}
	
	/**
	 * @methodtype get
	 * Returns the Weight of the Ball
	 * */
	public double getWeight() {
		
		return m_weight;
	}

	/**
	 * @methodtype get
	 * Returns the Manufacturer of the Ball
	 * */
	public String getManufacturer() {
		
		return m_manufacturer;
	}
	/**
	 * @methodtype get
	 * Returns the Year, the ball enter the Market 
	 * */
	public String getMarketYear() {
		
		return m_marketYear;
	}

//-----------------Setter------------------------------------------------------
	
	/**
	 * @methodtype set
	 * Set's the Type of the Football
	 * */
	public void setFootballType(FootballType type) {
		
		m_type = type;
	}
	
	/**
	 * @methodtype set
	 * Set's the Diameter of the ball
	 * */
	public void setDiameter(double diameter) {
		
		assertIsLegalDiameter(diameter);
		m_diameter = diameter;
	}

	/**
	 * @methodtype set
	 * Sets's the Weight of the ball
	 * */
	public void setWeight(double weight) {
		
		assertIsLegalWeight(weight);
		m_weight = weight;
	}
	
	/**
	 * @methodtype set
	 * Sets's the Manufacturer of the ball
	 * */
	public void setManufacturer(String manufacturer) {
		
		CommonUsedAsserts.assertIsNonNullObject(manufacturer, "The manufacturer cannot be null");
		m_manufacturer = manufacturer;
	}

	/**
	 * @methodtype set
	 * Sets's the MarketYear of the ball
	 * */
	public void setMarketYear(String marketYear) {
		
		CommonUsedAsserts.assertIsNonNullObject(marketYear, "Year of Entry cannot be null");
		this.m_marketYear = marketYear;
	} 
	
//-----------------Assertions, Pre and Postconditions
	
	private void assertClassInvariants() {
				
	}
	private void assertIsLegalWeight(double value) {
		
		if (value > 450.0 || value < 200.0)
			throw new IllegalArgumentException("Weight of the Ball: 200g - 450g inc!");
		CommonUsedAsserts.assertIsValidDouble(value);
	}
	private void assertIsLegalDiameter(double value) {
		
		CommonUsedAsserts.assertIsValidDouble(value);
		if (value > 70.0 || value < 14.5)
			throw new IllegalArgumentException("Range of the Ball: 14.5cm - 70.0cm inc!");
		
		return;
	}
	
	
	
}
