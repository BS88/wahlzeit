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

import org.wahlzeit.annotation.PatternInstance;

/**
 * The Cartesian Coordinate Class is representing an 3-dimensional Vector for geographical 
 *  
 */
@PatternInstance (
	name 		 = "Template Method",
	participants = {"ConcreteClass"}	
	)
public final class CartesianCoordinate extends AbstractCoordinate {
	
	private static final HashMap<Integer,CartesianCoordinate> 
		usedCartesianCoordinates = new HashMap<>();
	
	private static final Object lock  = new Object();
	
	/*-------------------------Member----------------------------------------*/
	private final double m_xCoordinate;
	private final double m_yCoordinate;
	private final double m_zCoordinate;
	
	/*-------------------------Ctors-----------------------------------------*/
		
	//
	private CartesianCoordinate (double x, double y, double z) {
		
		m_xCoordinate 	= x;
		m_yCoordinate 	= y;
		m_zCoordinate   = z;
		
		assertClassInvariants();
	}
		
	/*-------------------------Getter----------------------------------------*/

	public double getXcoordinate() {
		
		return m_xCoordinate;
	}
	
	public double getYcoordinate() {
		
		return m_yCoordinate;
	}

	public double getZcoordinate() {
		
		return m_zCoordinate;
	}
		
	//-------------------------public functions------------------------------------------------
	
	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinates() {
		return this;
	}
	
	/**
	 * Inherited  by AbstractCoordinate
	 *	
	 * Calculates the Euclidean distance between this Coordinate and one given Coordinate.  
	 * 
	 *  f(x) = sqrt(x² + y² + z²)
	 * @return Euclidean Distance between two Coordinates
	 * @param other -> other Coordinate
	 * 
	 */ 
	@Override
	public double getCartesianDistance(Coordinate other) {
		
		assertIsNonNullObject(other);
		
		CartesianCoordinate tmp = coordinateSubstraction(this, other.asCartesianCoordinates());
		return Math.sqrt(Math.pow(tmp.getXcoordinate(), 2) + 
						 Math.pow(tmp.getYcoordinate(), 2) + 
						 Math.pow(tmp.getZcoordinate(), 2));
		
	}
	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public  SphericCoordinate asSphericCoordinate() {

		double _radius = Math.sqrt(m_xCoordinate * m_xCoordinate + 
					m_yCoordinate * m_yCoordinate + m_zCoordinate *m_zCoordinate );
		assertIsValidDouble(_radius);
		
		if (_radius == 0.0) 
			return SphericCoordinate.getCoordinate(0, 0, 0);
		
		
		double _rho = Math.toDegrees(Math.acos(m_zCoordinate/_radius));
		assertIsValidDouble(_rho);
		
		double _phi = Math.toDegrees(Math.atan2(m_yCoordinate, m_xCoordinate));
		assertIsValidDouble(_phi);
		
		return SphericCoordinate.getCoordinate(_rho, _phi, _radius);
		
	}
	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public double getSphericDistance(Coordinate other) {
		
		assertIsNonNullObject(other);
		return this.asSphericCoordinate().getDistance(other);
	}
	
	public static CartesianCoordinate getCoordinate(double x, double y, double z ) {
		CartesianCoordinate coord = new CartesianCoordinate(x, y, z);
		synchronized(lock) {
			
			if (usedCartesianCoordinates.containsKey(coord.hashCode())) 
			{
				return usedCartesianCoordinates.get(coord.hashCode());
			}
			else 
			{
				usedCartesianCoordinates.put(coord.hashCode(), coord);
			}
		}
		return coord;
	}
	
	
	@Override
	public int hashCode()
	{
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
			
		return "X = "+m_xCoordinate + "Y = " +m_yCoordinate + "Z = " +m_zCoordinate; 
	}
	
//-------------------------private helper functions----------------------------------------		
	/**
	 *@method 
	 *
	 */
	private CartesianCoordinate coordinateSubstraction(CartesianCoordinate a, CartesianCoordinate b ) {
		
		double x_diff = a.getXcoordinate()- b.getXcoordinate();
		double y_diff = a.getYcoordinate()- b.getYcoordinate();
		double z_diff = a.getZcoordinate()- b.getZcoordinate();
		
		return new CartesianCoordinate(x_diff, y_diff, z_diff);
	}

	@Override
	protected void assertClassInvariants() {
		
		assertIsValidDouble(m_xCoordinate);
		assertIsValidDouble(m_yCoordinate);
		assertIsValidDouble(m_zCoordinate);
	}
}
