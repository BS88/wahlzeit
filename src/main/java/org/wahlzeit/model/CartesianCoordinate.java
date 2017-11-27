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
 * The Cartesian Coordinate Class is representing an 3-dimensional Vector for geographical 
 *  
 */
public class CartesianCoordinate extends AbstractCoordinate
{
		
	/*-------------------------Member----------------------------------------*/
	private double m_xCoordinate = 0d;
	private double m_yCoordinate = 0d;
	private double m_zCoordinate = 0d;
	
	/*-------------------------Ctors-----------------------------------------*/
	
	//Standard
	public CartesianCoordinate() {
		
	}
	
	//specified with given Coordinates
	public CartesianCoordinate (double x, double y, double z) {
		
		m_xCoordinate 	= x;
		m_yCoordinate 	= y;
		m_zCoordinate   = z;
	}
	
	public CartesianCoordinate (CartesianCoordinate other) {
		
		if (null == other)
			return;

		m_xCoordinate = other.getXcoordinate();
		m_yCoordinate = other.getYcoordinate();
		m_zCoordinate = other.getZcoordinate();
	}
		
	/*-------------------------Getter----------------------------------------*/

	public double getXcoordinate() {
		
		return m_xCoordinate;
	}
	
	public double getYcoordinate() {
		
		return m_yCoordinate;
	}

	public double getZcoordinate(){
		
		return m_zCoordinate;
	}
	
	/*-------------------------Setter----------------------------------------*/
	
	public void setXcoordinate(double xCoordinate) {
		
		this.m_xCoordinate = xCoordinate;
	}

	public void setYcoordinate(double yCoordinate) {
		
		this.m_yCoordinate = yCoordinate;
	}

	public void setZcoordinate(double zCoordinate) {
		
		this.m_zCoordinate = zCoordinate;
	}
	
	//-------------------------public functions------------------------------------------------
	
	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinates()
	{
		CartesianCoordinate _result = new CartesianCoordinate(this);
		return _result;
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
	public double getCartesianDistance(Coordinate other)
	{
		if (null == other)
			throw new IllegalArgumentException("Coordinate must not be null!");
		
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
	public SphericCoordinate asSphericCoordinate() {

		double _radius = Math.sqrt(m_xCoordinate * m_xCoordinate + 
					m_yCoordinate * m_yCoordinate + m_zCoordinate *m_zCoordinate );
		
		double _rho = Math.toDegrees(Math.acos(m_zCoordinate/_radius));
		double _phi = Math.toDegrees(Math.atan2(m_yCoordinate, m_xCoordinate));
		
		if (Double.isNaN(_radius))
			_radius = 0; 
		if (Double.isNaN(_rho))
			_rho = 0;
		if (Double.isNaN(_phi))
			_phi = 0;

		return new SphericCoordinate(_rho, _phi, _radius);
	}
	/**
	 * Inherited  by AbstractCoordinate
	 * 
	 */
	@Override
	public double getSpharicDistance(Coordinate other) {
		
		return this.asSphericCoordinate().getDistance(other);
	}
	
//-------------------------private helper functions----------------------------------------*/		
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
}
