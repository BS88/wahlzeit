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
 * The SphericCoordinate Class represents a  specific implementation of Coordinates.
 * inspired by: // source https://de.wikipedia.org/wiki/Kugelkoordinaten
 */

public class SphericCoordinate extends AbstractCoordinate
{
	
	
//-------------------------Member----------------------------------------------	
	
	//Range from -90° to 90 °
	private double m_latitude 	= 0.0;
	
	//Range from -180° to 180°
	private double m_longtitude = 0.0;
	
	// Range greater than Zero
	private double m_radius 	= 0.0;
	
//-------------------------Ctors-----------------------------------------------
	
	
	public SphericCoordinate() {
		
		assertClassInvariants();
	}
	
	public SphericCoordinate(double latitude, double longtitude, double radius) {
		
		assertLatitudeInRange(latitude);
		assertLongtitudeInRange(longtitude);
		assertRadiusGreaterZero(radius);
		
		m_latitude 	 = latitude;	
		m_longtitude = longtitude;
		m_radius 	 = radius;
		
		assertClassInvariants();
	}
	
	public SphericCoordinate(Coordinate other) {
		
		assertIsNonNullObject(other);
		
		if (other instanceof SphericCoordinate)
		{
			SphericCoordinate tmp = (SphericCoordinate) other;
			
			m_latitude   = tmp.getLatitude();
			m_longtitude = tmp.getLongtitude();
			m_radius	 = tmp.m_radius;
		}
		else 
		{
			m_latitude	 	= other.asSphericCoordinate().getLatitude();
			m_longtitude	= other.asSphericCoordinate().getLongtitude();
			m_radius 		= other.asSphericCoordinate().getRadius();
		}
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

	public double getLongtitude(){
		
		return m_longtitude;
	}
	
	/*-------------------------Setter----------------------------------------*/

	public void setRadius(double radius) {
		
		assertRadiusGreaterZero(radius);	
		m_radius = radius;
	}

	public void setLatitude(double latitude) {
		
		assertLatitudeInRange(latitude);
		m_latitude = latitude;
	}


	public void setLongtitude(double longtitude) {
	
		assertLongtitudeInRange(longtitude);
		m_longtitude = longtitude;
	}

	//-------------------------public functions------------------------------------------------

	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinates() {
		
		assertClassInvariants();
		double _latRad  = Math.toRadians(m_latitude);
		double _longRad = Math.toRadians(m_longtitude);
		
		double _xCoord = m_radius * Math.sin(_latRad) * Math.cos(_longRad);
		double _yCoord = m_radius * Math.sin(_latRad) *Math.sin(_longRad);
		double _zCoord = m_radius * Math.cos(_latRad);
		assertClassInvariants();
		
		return new CartesianCoordinate(_xCoord, _yCoord, _zCoord);
		
	}
	
	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public double getCartesianDistance(Coordinate other) {
		assertIsNonNullObject(other);
		return this.asCartesianCoordinates().getCartesianDistance(other);
	}
	
	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {	
		SphericCoordinate _result = new SphericCoordinate(this);
		return _result;
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
	//-------------------------Assertion Methods-------------------------------
	
	private void assertClassInvariants() {
		assertLatitudeInRange(m_latitude);
		assertLongtitudeInRange(m_longtitude);
		assertRadiusGreaterZero(m_radius);
	}
	private void assertRadiusGreaterZero(double radius) {
		assertIsNonNullObject(radius);
		if (radius < 0)
			throw new IllegalStateException("Radius of an Spheric Coordinate can not be negative");
	}
	
	private void assertLatitudeInRange(double latitude) {
		assertIsNonNullObject(latitude);
		if (latitude < -90.0  || latitude > 90.0)
			throw new IllegalStateException("Latitude of an Spheric Coordinate "
					+ "must be within -90 ° to 90°.");
	}
	
	private void assertLongtitudeInRange(double longtitude) {
		assertIsNonNullObject(longtitude);
		if(m_longtitude < -180 || m_longtitude > 180)
			throw new IllegalStateException("Longtitude of an Spheric Coordinate "
					+ "must be within -180 ° to 180°.");
	}
}
