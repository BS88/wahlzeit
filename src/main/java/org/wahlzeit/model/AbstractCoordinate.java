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
 * A generic implementation of Coordinates.
 * Subclasses provide the specialized geographic implementation.
 */
public abstract class AbstractCoordinate implements Coordinate
{
	/**
	 * Highest Error Barrier Epsilon.
	 * 
	 */
	public static final double EPSILON = 1.0E-7;

//----------------Abstract functions-------------------------------------------
	/**
	 * 
	 * Implemented by Subclasses
	 */

	public abstract CartesianCoordinate asCartesianCoordinates();
	public abstract double getCartesianDistance(Coordinate other);
	public abstract SphericCoordinate asSphericCoordinate();
	public abstract double getSpharicDistance(Coordinate other);
	
//----------------------Overrides----------------------------------------------
	
	
	@Override
	public double getDistance(Coordinate other)
	{
		if (null == other)
			throw new IllegalArgumentException("Coordinate must not be null");
		
		if (this instanceof CartesianCoordinate)
			return this.getCartesianDistance(other);
		else
			return this.asCartesianCoordinates().getCartesianDistance(other);
	}

	@Override
	public boolean isEqual(Coordinate other)
	{
		if (null == other)
			throw new IllegalArgumentException("Coordinate must not be null");
		
		if (this instanceof CartesianCoordinate) 
		{
			double _distanceCartesian = this.getCartesianDistance(other);
			return isDoubleEqual(_distanceCartesian, 0d);
		}
		else
		{
			double _distanceSpheric = this.getSpharicDistance(other);
			return isDoubleEqual(_distanceSpheric, 0d);
		}
	}
	
	@Override
	public boolean equals(Object o)
	{
		if ( null == o )
			throw new IllegalArgumentException("Object must not be null");
		
		if (o instanceof Coordinate)
			return isEqual((Coordinate) o);
		
		return false;
	}

	//-------------------------Private Helper----------------------------------
	
	/**
	 * 
	 * @methodtype compare
	 * 
	 */
	private boolean isDoubleEqual(double one, double two) 
	{
		return (Math.abs(one - two) < EPSILON) ? true : false;
	}
	
	
}
