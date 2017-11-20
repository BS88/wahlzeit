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

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Testcases for Location Class
 */
public class LocationTest {

	@Test
	public void testLocationCreate() {
		
		Location tmpOne	= new Location(new SphericCoordinate());
		Location tmpTwo = new Location();
		
		Location _result 	= new Location();
				
		assertEquals(_result.getCoordinate(), tmpOne.getCoordinate());
		assertEquals(_result.getCoordinate(), tmpTwo.getCoordinate());
		
	}
	@Test
	public void testLocationName() {
		Location tmpOne	= new Location(new CartesianCoordinate(), "HansMeiser");
		Location tmpTwo = new Location();
		
		Location _result 	= new Location();
		_result.setLocationName("HansMeiser");
	
		
		assertEquals(_result.getLocationName(), tmpOne.getLocationName());
		tmpTwo.setLocationName("HansMeiser");
		assertEquals(_result.getLocationName(), tmpTwo.getLocationName());

	
	}
	@Test
	public void testLocationCoordinates() {
		Location tmpOne	= new Location(new CartesianCoordinate(1.0,0,0), "HansMeiser");
		Location tmpTwo = new Location();
		
		Coordinate _result 	= new CartesianCoordinate(1.0, 0,0);
		tmpTwo.setCoordinate(_result);
		assertEquals(_result, tmpOne.getCoordinate());
		assertEquals(_result, tmpTwo.getCoordinate());

	
		
	}	

}
