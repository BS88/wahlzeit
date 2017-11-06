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

import java.math.*;

/**
 * The Coordinate Class is representing an 3-dimensional Vector with Cartesian 
 * coordinates.
 */
public class Coordinate
{
	/**
	 * Highest Error Barrier Epsilon.
	 */
	private static final double EPSILON = 1.0E-7;
	
	/*-------------------------Member----------------------------------------*/
		
		private double m_xCoordinate = 0.0;
		private double m_yCoordinate = 0.0;
		private double m_zCoordinate = 0.0;
	
	
	

	/*-------------------------Ctors-----------------------------------------*/
	
	//Standard
	public Coordinate()
	{}
	
	//specified with given Coordinates
	public Coordinate (double xCoordinate, double yCoordinate, double zCoordinate)
	{
		m_xCoordinate 	= xCoordinate;
		m_yCoordinate 	= yCoordinate;
		m_zCoordinate   = zCoordinate;
	}
	public Coordinate (Coordinate other) {
		
		if (null == other)
			return;

		m_xCoordinate = other.getXcoordinate();
		m_yCoordinate = other.getYcoordinate();
		m_zCoordinate = other.getZcoordinate();
		
	}
	
	/*-------------------------End Ctor--------------------------------------*/

	
	/*-------------------------Getter----------------------------------------*/

	public double getXcoordinate()
	{
		return m_xCoordinate;
	}
	
	public double getYcoordinate()
	{
		return m_yCoordinate;
	}

	public double getZcoordinate()
	{
		return m_zCoordinate;
	}
	
	//Setter--------------------------------------------------------
	
	
	
	public void setXcoordinate(double xCoordinate)
	{
		this.m_xCoordinate = xCoordinate;
	}



	public void setYcoordinate(double yCoordinate)
	{
		this.m_yCoordinate = yCoordinate;
	}


	public void setZcoordinate(double zCoordinate)
	{
		this.m_zCoordinate = zCoordinate;
	}
	
	//-------------------------public functions------------------------------------------------
	
	@Override
	public boolean equals(Object o) 
	{
		if (this == o)
			return true;
		if (null == o)
			return false;
		
		if (o instanceof Coordinate)
			return isEqual((Coordinate)o);
		
		return false;
	}
	
	/**
	 * Calculates the Euclidean distance between this Coordinate and one given Coordinate.  
	 * 
	 *  f(x) = sqrt(x² + y² + z²)
	 * @return Euclidean Distance between two Coordinates
	 * @param other -> other Coordinate
	 * 
	 */	
	public double getDistance(Coordinate other) {
		if (this == other)
			return 0.0;
		
		Coordinate tmp = coordinateSubstraktion(this, other);
		
		return Math.sqrt(Math.pow(tmp.getXcoordinate(), 2) + 
						 Math.pow(tmp.getYcoordinate(), 2) + 
						 Math.pow(tmp.getZcoordinate(), 2));
						
	}
	
	//-------------------------private functions----------------------------------------*/
	
	private boolean isEqual(Coordinate other) 
	{
		Coordinate diff = coordinateSubstraktion(this, other);
		
		if (Math.abs(diff.getXcoordinate()) > EPSILON)
			return false;
		if (Math.abs(diff.getYcoordinate()) > EPSILON)
			return false; 
		if (Math.abs(diff.getZcoordinate()) > EPSILON)
			return false;
		
		return true;
	}
	private Coordinate coordinateSubstraktion(Coordinate a, Coordinate b ) {
		
		double x_diff = a.getXcoordinate()- b.getXcoordinate();
		double y_diff = a.getYcoordinate()- b.getYcoordinate();
		double z_diff = a.getZcoordinate()- b.getZcoordinate();
		
		return new Coordinate(x_diff, y_diff, z_diff);
	}
	
	
	
	//*-------------------------Getter----------------------------------------*/
	
}
