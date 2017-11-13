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
 * The Location describes the Area based on Cartesian Coordinates where the Photo was taken. 
 */
public class Location
{
	
	private Coordinate 	mCoordinate 	= null;
	private String			mLocationName 	= null;
	
	/**
	 *
	 */
	public Location() {
		mCoordinate = new Coordinate();
	}
	
	/**
	 *
	 */
	public Location(Coordinate coordinate) {
		
		if (null == coordinate)
			mCoordinate = new Coordinate();
		else 
			mCoordinate = coordinate;
	}
	/**
	 *
	 */
	public Location(Coordinate coordinate, String locationName) {
		
		this(coordinate);
		
		if (null != locationName || locationName != " ")
			mLocationName = locationName;
	}
	
	// Getter and Setter ------------------------------------------------------
	
	/**
	 * @methodtype get
	 */
	
	public Coordinate getCoordinate() {
		return mCoordinate;
	}

	/**
	 * @methodtype get
	 */

	public String getLocationName() {
		return mLocationName;
	}
	
	/**
	 * @methodtype set
	 */
	public void setCoordinate (Coordinate coordinate) {
		mCoordinate = coordinate;
	}
	
	/**
	 * @methodtype set
	 */
	public void setLocationName(String locationName) {
		mLocationName = locationName;
	}
}
