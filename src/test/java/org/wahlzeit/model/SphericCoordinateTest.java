
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
import org.junit.Assert;
import org.junit.Test;

public class SphericCoordinateTest
{
	@Test
	public void testSphericCoordinateCreation() {
	
	SphericCoordinate one = new SphericCoordinate();
	SphericCoordinate two = new SphericCoordinate();
			

	SphericCoordinate _resultOne = new SphericCoordinate(1.0,2.0,3.0);
	SphericCoordinate _resultTwo = new SphericCoordinate(2.0,3.0,4.0);
	
	assertEquals(one, new SphericCoordinate());
	assertEquals(two, new SphericCoordinate(0,0,0));
			
	assertEquals(_resultOne, new SphericCoordinate(_resultOne));
	assertTrue(_resultOne.equals(_resultOne));
	assertTrue(_resultOne.equals(new SphericCoordinate(1,2,3)));
	assertFalse(_resultOne.equals(_resultTwo));
			
		}
		@Test
		public void testSphericCoordinateTestGetterandSetter() {
			
			SphericCoordinate one = new SphericCoordinate();
			SphericCoordinate two = new SphericCoordinate();
		
			one.setLatitude(40);
			one.setLongtitude(-50);
			one.setRadius(10);
			
			two.setLatitude(89);
			two.setLongtitude(-100);
			two.setRadius(15);
			
			
			assertEquals(40, one.getLatitude(), 1E-7);
			assertEquals(-100, two.getLongtitude(), 1E-7);
			assertFalse(11 == one.getRadiu());

		}
		@Test
		public void testDistance() {
			
			SphericCoordinate one = new SphericCoordinate(54,45,1.73);
			SphericCoordinate two = new SphericCoordinate(54,45,1.73);
			
			assertEquals(one.getDistance(two),0,1E-7);
			assertEquals(two.getDistance(new SphericCoordinate()),1.73,1E-7 );
			
			one.setLatitude(68.75);
			one.setLongtitude(116.31);
			one.setRadius(4.78);
		
			assertEquals(Math.sqrt(Math.pow(-2, 2)+Math.pow(4,2)+Math.pow(1.7, 2)),
					one.getDistance(new SphericCoordinate()),1E-1);
			
		}
	}


