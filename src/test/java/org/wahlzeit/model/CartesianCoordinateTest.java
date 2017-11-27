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

public class CartesianCoordinateTest {

	@Test
	public void testCartesianCoordinateCreation() {
		
		CartesianCoordinate one = new CartesianCoordinate();
		CartesianCoordinate two = new CartesianCoordinate();
		

		CartesianCoordinate _resultOne = new CartesianCoordinate(1.0,2.0,3.0);
		CartesianCoordinate _resultTwo = new CartesianCoordinate(2.0,3.0,4.0);
	
		assertEquals(one, new CartesianCoordinate());
		assertEquals(two, new CartesianCoordinate(0,0,0));
		
		assertEquals(_resultOne, new CartesianCoordinate(_resultOne));
		assertTrue(_resultOne.equals(_resultOne));
		assertTrue(_resultOne.equals(new CartesianCoordinate(1,2,3)));
		assertFalse(_resultOne.equals(_resultTwo));
		
	}
	@Test
	public void testCartesianCoordinateGetterandSetter() {
		
		CartesianCoordinate one = new CartesianCoordinate();
		CartesianCoordinate two = new CartesianCoordinate();
	
		one.setXcoordinate(1.0);
		one.setYcoordinate(5.0);
		one.setZcoordinate(8.0);
		
		two.setXcoordinate(-1.0);
		two.setYcoordinate(-4.0);
		two.setZcoordinate(-4.44);
		
		assertEquals(1.0, one.getXcoordinate(), 1E-7);
		assertEquals(-4, two.getYcoordinate(), 1E-7);
		assertFalse(8.001 == one.getZcoordinate());

	}
	@Test
	public void testDistance() {
		
		CartesianCoordinate one = new CartesianCoordinate(1.0,1.0,1.0);
		CartesianCoordinate two = new CartesianCoordinate(1.0,1.0,1.0);
		
		assertEquals(one.getDistance(two),0,1E-7);
		assertEquals(two.getDistance(new CartesianCoordinate()),1.732050808,1E-8 );
		
		one.setXcoordinate(-2);
		one.setYcoordinate(4);
		one.setZcoordinate(1.7);
	
		assertEquals(Math.sqrt(Math.pow(-2, 2)+Math.pow(4,2)+Math.pow(1.7, 2)),
				one.getDistance(new CartesianCoordinate()),1E-7);
		
	}
	@Test
	public void testCartesianCoordinateEquals() {
		
		CartesianCoordinate one = new CartesianCoordinate(4.1,4.2,4.3);
		CartesianCoordinate two = new CartesianCoordinate(4.11,4.22,4.33);
		
		assertFalse(one.equals(two));
		two.setXcoordinate(4.099999);
		two.setYcoordinate(4.199999);
		two.setZcoordinate(4.299999);
		
		assertFalse(one.equals(two));
		
		two.setXcoordinate(4.0999999999);
		two.setYcoordinate(4.1999999999);
		two.setZcoordinate(4.2999999999);
		
		assertTrue(one.equals(two));

	}
	
}
