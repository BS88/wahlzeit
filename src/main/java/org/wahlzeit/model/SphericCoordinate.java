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

import java.util.HashMap;

/**
 * The SphericCoordinate Class represents a  specific implementation of Coordinates.
 * inspired by: // source https://de.wikipedia.org/wiki/Kugelkoordinaten
 */

public final class SphericCoordinate extends AbstractCoordinate {
	
	
	// Cache for used Coordinates
	private final static HashMap<Integer,SphericCoordinate> coordinateCache = new HashMap<>();
	
	private static final Object lock  = new Object();
	
//-------------------------Member----------------------------------------------	
	
	//Range from -90° to 90 °
	private final double m_latitude ;
	
	//Range from -180° to 180°
	private final double m_longtitude;
	
	// Range greater than Zero
	private final double m_radius ;
	
//-------------------------Ctors-----------------------------------------------
	
	
	private SphericCoordinate(double latitude, double longtitude, double radius) {
		
		assertLatitudeInRange(latitude);
		assertLongtitudeInRange(longtitude);
		assertRadiusGreaterZero(radius);
		
		m_latitude 	 = latitude;	
		m_longtitude = longtitude;
		m_radius 	 = radius;
		
		assertClassInvariants();
	}
//-------------------------Getter----------------------------------------------

	/**
	 * @methodtype get
	 */	
	public double getRadius() {
		
		return m_radius;
	}
	
	public double getLatitude() {
		
		return m_latitude;
	}

	public double getLongtitude() {
		
		return m_longtitude;
	}
	
	public static SphericCoordinate getCoordinate(double latitude, double longtitude, double radius) {
		
		SphericCoordinate coord = new SphericCoordinate(latitude, longtitude, radius);
		
		synchronized (lock)
		{
			if (coordinateCache.containsKey(coord.hashCode())) 
			{
				return coordinateCache.get(coord.hashCode());
			}
			else 
			{
				coordinateCache.put(coord.hashCode(), coord);
			}
		}
		return coord;
	}
	
//-------------------------public functions------------------------------------------------

	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinates() throws IllegalStateException {
		
		assertClassInvariants();
		double _latRad  = Math.toRadians(m_latitude);
		double _longRad = Math.toRadians(m_longtitude);
		
		double _xCoord = m_radius * Math.sin(_latRad) * Math.cos(_longRad);
		double _yCoord = m_radius * Math.sin(_latRad) *Math.sin(_longRad);
		double _zCoord = m_radius * Math.cos(_latRad);
		assertClassInvariants();
		
		return CartesianCoordinate.getCoordinate(_xCoord, _yCoord, _zCoord);
	}
	
	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public double getCartesianDistance(Coordinate other ) {
		assertIsNonNullObject(other);
		return this.asCartesianCoordinates().getCartesianDistance(other);
	}
	
	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
	
		return this;
	}
	
	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public double getSphericDistance(Coordinate other) {		
		assertIsNonNullObject(other);
		
		return this.asCartesianCoordinates().getCartesianDistance(other);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		
		return "Latitude = " +m_latitude+ "Longtitude = " +m_longtitude+
				"Radius = " +m_radius; 
	}
	
	//-------------------------Assertion Methods-------------------------------
	
	protected void assertClassInvariants() throws IllegalArgumentException {
		
		String member= " ";
		for (int i = 0; i < 3; i++) {
		try {
			if (i == 0) {
				member = "Latitude";
				assertLatitudeInRange(m_latitude);
			}
			else if (i == 1) {
				member = "Longtitude";
				assertLongtitudeInRange(m_longtitude);
			}
			else {
				member = "Radius";
				assertRadiusGreaterZero(m_radius);
			}
		}
		catch (IllegalArgumentException exc) {
			throw new IllegalStateException("Error. Member " + member 
					+ ", has an invalid State.\n" );
		}
		}
	}
	private void assertRadiusGreaterZero(double radius) throws IllegalArgumentException {
		assertIsValidDouble(radius);
		if (radius < 0)
			throw new IllegalArgumentException("Radius of an Spheric Coordinate can not be "
					+ "negative. Value was" +radius+".");
	}
	
	private void assertLatitudeInRange(double latitude) throws IllegalArgumentException {
		assertIsValidDouble(latitude);
		if (latitude < -90.0  || latitude > 90.0)
			throw new IllegalArgumentException("Latitude of an Spheric Coordinate "
					+ "must be within -90 ° to 90°. Value was : " +latitude+".");
	}
	
	private void assertLongtitudeInRange(double longtitude) throws IllegalArgumentException {
		assertIsValidDouble(longtitude);
		if(m_longtitude < -180 || m_longtitude > 180)
			throw new IllegalArgumentException("Longtitude of an Spheric Coordinate "
					+ "must be within -180 ° to 180°. Value was : " +longtitude +"." );
	}
}
