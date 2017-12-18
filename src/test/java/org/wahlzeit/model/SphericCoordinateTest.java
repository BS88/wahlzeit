
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

public class SphericCoordinateTest
{
	@Test
	public void testSphericCoordinateCreation() {
	
	SphericCoordinate one = SphericCoordinate.getCoordinate(0, 0, 0);
	SphericCoordinate two = SphericCoordinate.getCoordinate(0, 0, 0);
	

	SphericCoordinate _resultOne = SphericCoordinate.getCoordinate(1.0,2.0,3.0);
	SphericCoordinate _resultTwo = SphericCoordinate.getCoordinate(2.0,3.0,4.0);
	
	assertEquals(one, two);
			
	assertEquals(_resultOne, SphericCoordinate.getCoordinate(1.0,2.0,3.0));
	assertFalse(_resultOne.equals(_resultTwo));
			
	}

	@Test
	public void testDistance() {
			
			SphericCoordinate one = SphericCoordinate.getCoordinate(54,45,1.73);
			SphericCoordinate two = SphericCoordinate.getCoordinate(54,45,1.73);
			
			assertEquals(one.getDistance(two),0,1E-7);
			assertEquals(two.getDistance(SphericCoordinate.getCoordinate(0,0,0)),1.73,1E-7 );
			

		
			SphericCoordinate three = SphericCoordinate.getCoordinate(68.75,116.31 ,4.78);
			
			assertEquals(Math.sqrt(Math.pow(-2, 2)+Math.pow(4,2)+Math.pow(1.7, 2)),
					three.getDistance(SphericCoordinate.getCoordinate(0,0,0)),1E-1);	
		}
	}


