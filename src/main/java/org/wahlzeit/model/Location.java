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


/**
 * The Location describes the Area based on Cartesian Coordinates or Spheric Coordinates 
 *  where the Photo was taken. 
 */
public class Location
{
	
	private Coordinate 		m_coordinate 	= null;
	private String			m_locationName 	= null;
	
	/**
	 *
	 */
	public Location() { }
	
	/**
	 *
	 */
	public Location(Coordinate coordinate) {
		
		m_coordinate = coordinate;
	}
	/**
	 *
	 */
	public Location(Coordinate coordinate, String locationName) {
		
		this(coordinate);
		
		if (null != locationName || locationName != " ")
			m_locationName = locationName;
	}
	
	// Getter and Setter ------------------------------------------------------
	
	/**
	 * @methodtype get
	 */
	
	public Coordinate getCoordinate() {
		return m_coordinate;
	}

	/**
	 * @methodtype get
	 */

	public String getLocationName() {
		return m_locationName;
	}
	
	/**
	 * @methodtype set
	 */
	public void setCoordinate (Coordinate coordinate) {
		m_coordinate = coordinate;
	}
	
	/**
	 * @methodtype set
	 */
	public void setLocationName(String locationName) {
		m_locationName = locationName;
	}
}
