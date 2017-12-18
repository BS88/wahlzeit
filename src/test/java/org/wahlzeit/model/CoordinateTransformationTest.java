package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTransformationTest
{
	@Test
	public void testCartesianToSphericCoordinates() {
		
		CartesianCoordinate one 	= CartesianCoordinate.getCoordinate(0,0,0);
		CartesianCoordinate two	  	= CartesianCoordinate.getCoordinate(1,1,1);
		//CartesianCoordinate three 	= new CartesianCoordinate();
		
		SphericCoordinate test_one = SphericCoordinate.getCoordinate(54.73561031738112348,45.000000000111633369,
				1.7320508075688772);
		
		SphericCoordinate test_two = SphericCoordinate.getCoordinate(0,0,0);
		
		
		assertEquals(two.asSphericCoordinate().getRadius(), test_one.getRadius(),1E-5);
		assertEquals(two.asSphericCoordinate().getLongtitude(), test_one.getLongtitude(),1E-5);
		assertEquals(two.asSphericCoordinate().getLatitude(), test_one.getLatitude(), 1E-5);
		
		assertEquals(one.asSphericCoordinate().getRadius(), test_two.getRadius(),1E-5);
		assertEquals(one.asSphericCoordinate().getLongtitude(), test_two.getLongtitude(),1E-5);
		assertEquals(one.asSphericCoordinate().getLatitude(), test_two.getLatitude(), 1E-5);
	
	}
	@Test
	public void SphericCoordinatestestToCartesian()
	{
		//CartesianCoordinate three 	= new CartesianCoordinate();
		
		SphericCoordinate one = SphericCoordinate.getCoordinate(54.73561031738112348,45.000000000111633369,
				1.7320508075688772);
		
	
		
		CartesianCoordinate test_one 	= CartesianCoordinate.getCoordinate(1,1,1);
		
		assertEquals(one.asCartesianCoordinates().getXcoordinate(),test_one.getXcoordinate() ,1E-5);
		assertEquals(one.asCartesianCoordinates().getYcoordinate(),test_one.getYcoordinate() ,1E-5);
		assertEquals(one.asCartesianCoordinates().getZcoordinate(),test_one.getZcoordinate() ,1E-5);

		assertTrue(one.asCartesianCoordinates().equals(test_one));
		assertFalse(one.asCartesianCoordinates().equals(CartesianCoordinate.getCoordinate(0,0,0)));
		
	}
}
