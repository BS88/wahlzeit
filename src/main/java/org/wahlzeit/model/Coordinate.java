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
 * The Coordinate Class is representing an 3-dimensional Vector with Cartesian 
 * coordinates.
 */
public interface Coordinate
{	
	/**
	 * @methodType conversion
	 * Converts the given Coordinate to Cartesian Coordinates
	 */
	public CartesianCoordinate asCartesianCoordinates();
	/**
	 * @methodType get
	 * Returns the distance Cartesian between two Coordinates
	 */
	public double getCartesianDistance(Coordinate other);
	/**
	 * @methodType conversion
	 * Converts the given Coordinate to Spheric Coordinates
	 */
	public SphericCoordinate asSphericCoordinate ();
	/**
	 * @methodType get
	 * Returns the Spharic distance between two Coordinates
	 */
	public double getSpharicDistance (Coordinate other);
	/**
	 * @methodType get
	 * Returns the distance between two Coordinates
	 */
	public double getDistance(Coordinate other);
	/**
	 * @methodType compare
	 * Compares two Coordinates if they are pointing the same Location 
	 */
	public boolean isEqual(Coordinate other);
	
}
