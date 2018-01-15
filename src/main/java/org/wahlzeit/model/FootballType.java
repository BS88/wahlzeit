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

import java.util.HashSet;
import java.util.Iterator;

import org.wahlzeit.annotation.PatternInstance;
import org.wahlzeit.services.DataObject;
import org.wahlzeit.utils.CommonUsedAsserts;


@PatternInstance
(
	name = "Type Object",
	participants = {"ObjectType"}
)

/**
 * 
 * The FootballType class represents the TypeObject of the Football
 * */
public class FootballType extends DataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String 				m_name;
	protected FootballType 				m_superType = null;
	protected HashSet<FootballType> 	m_subTypes  = new HashSet<>();
	
	public FootballType(String name) {
		
		m_name = name;		
	}
// ----------------Getter------------------------------------------------------
	
	/**
	 * 
	 * @methodtype get 
	 * Returns the name of the FootballType
	 * 
	 * */
	public String getName() {
		
		return m_name;
	}

	/**
	 * 
	 * @methodtype get 
	 * Returns the SuperType of this Type
	 *  
	 * */
	public FootballType getSuperType() {
		
		return m_superType;
	}
	
	/**
	 * 
	 * @methodtype get 
	 * Returns an iterator for the Subclasses from this Type
	 * 
	 * */
	public Iterator<FootballType> getSubTypeIterator() {
		
		return m_subTypes.iterator();
	}
	
//-----------------Setter------------------------------------------------------
	/**
	 * 
	 * @methodtype set
	 * Sets or Changes the Supertype of this Instance
	 * @param type
	 * 
	 * */
	public void setSuperType(FootballType type) {
		
		CommonUsedAsserts.assertIsNonNullObject(type, "Type must not be null");
		m_superType = type;
	}
	
//-----------------Public Methods----------------------------------------------	
	/**
	 * 
	 * @methodtype mutation
	 * Adds a Subtype to this Type
	 * @param type
	 * 
	 */
	
	public void addSubType(FootballType type) {
		
		CommonUsedAsserts.assertIsNonNullObject(type, "Type must not be null");
		type.setSuperType(this);
	}
	
	/**
	 * 
	 * @methodtype compare
	 * Compares this Instance and its subclasses with the Param
	 * 
	 * */
	public boolean isSubType(FootballType type) {

		CommonUsedAsserts.assertIsNonNullObject(type,"Type must not be null");
		
		if (type == this)
			return true;
		
		for(FootballType tmpType : m_subTypes) {
			if (type.isSubType(tmpType))
				return true;
		}
		return false;
	}
	
	public Football createFootball(String name) {
		
		return new Football(this, name);
		
	}
	
	
	
}
