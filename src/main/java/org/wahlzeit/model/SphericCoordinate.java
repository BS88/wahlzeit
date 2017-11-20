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


public class SphericCoordinate implements Coordinate
{
	// source https://de.wikipedia.org/wiki/Kugelkoordinaten
	
	//Range from -90� to 90 �
	private double m_latitude 	= 0.0;
	
	//Range from -180� to 180�
	private double m_longtitude = 0.0;
	
	// Range greater than Zero
	private double m_radius 	= 0.0;
	
	
	public SphericCoordinate() {}
	
	public SphericCoordinate(double latitude, double longtitude, double radius)
	{
		if (latitude < -90.0  || latitude > 90.0)
			throw new IllegalArgumentException("Error. Range of Latitude is -90� to 90�");
		
		if (longtitude < -180 || longtitude > 180)
			throw new IllegalArgumentException("Error. Range of Longtitude is -180� to +180�");
		
		if (radius < 0)
			throw new IllegalArgumentException("Error. Range of Radiu is greater than Zero");

		m_latitude 	 = latitude;	
		m_longtitude = longtitude;
		m_radius 	 = radius;
	}
	public SphericCoordinate(Coordinate other) 
	{
		if (null == other)
			throw new IllegalArgumentException("Error. Given coordinate must not be null");
		
		if (other instanceof SphericCoordinate)
		{
			SphericCoordinate tmp = (SphericCoordinate) other;
			
			m_latitude   = tmp.getLatitude();
			m_longtitude = tmp.getLongtitude();
			m_radius	 = tmp.m_radius;
		}
		else 
		{
			m_latitude = other.asSphericCoordinate().getLatitude();
			m_longtitude = other.asSphericCoordinate().getLongtitude();
			m_radius = other.asSphericCoordinate().getRadiu();
		} 
			
		
	}
	/*-------------------------Getter----------------------------------------*/

	public double getRadiu() {
		
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
		
		if (radius < 0)
			throw new IllegalArgumentException("Error. Range of Radius must be greater than Zero");
		m_radius = radius;
	}



	public void setLatitude(double latitude) {
		
		if (latitude < -90.0  || latitude > 90.0)
			throw new IllegalArgumentException("Error. Range of Latitude is -90� to 90�");
		m_latitude = latitude;
	}


	public void setLongtitude(double longtitude) {
		
		if (longtitude < -180 || longtitude > 180)
			throw new IllegalArgumentException("Error. Range of Longtitude is -180� to +180�");
		m_longtitude = longtitude;
	}

	//-------------------------public functions------------------------------------------------
	
	public boolean equals(Object o) 
	{
		if (this == o)
			return true;
		if (null == o)
			return false;
		
		if (o instanceof SphericCoordinate || o instanceof CartesianCoordinate )
			return this.asCartesianCoordinates().isEqual((Coordinate)o);
		
		return false;
	}
	
	
	
	@Override
	
	public CartesianCoordinate asCartesianCoordinates() {
		
		double _latRad  = Math.toDegrees(m_latitude);
		double _longRad = Math.toDegrees(m_longtitude);
		
		double _xCoord = m_radius * Math.sin(_latRad) * Math.cos(_longRad);
		double _yCoord = m_radius * Math.sin(_latRad) *Math.sin(_longRad);
		double _zCoord = m_radius * Math.cos(_latRad);
		
		return new CartesianCoordinate(_xCoord, _yCoord, _zCoord);
		
	}

	@Override
	public double getCartesianDistance(Coordinate other) {
		return this.asCartesianCoordinates().getCartesianDistance(other);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getSpharicDistance(Coordinate other) {
		
		if (null == other )
			throw new IllegalArgumentException("The given Parameter Coordinate must be not null!");
		
		return this.asCartesianCoordinates().getCartesianDistance(other);
	}

	@Override
	public double getDistance(Coordinate other)
	{
		if (null == other )
			throw new IllegalArgumentException("The given Parameter Coordinate must be not null!");
		
		return this.asCartesianCoordinates().getCartesianDistance(other);
	}

	@Override
	public boolean isEqual(Coordinate other)
	{
		if (null == other )
			throw new IllegalArgumentException("The given Parameter Coordinate must be not null!");
		
		return this.asCartesianCoordinates().isEqual(other);
	}

}