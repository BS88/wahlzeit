package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class FootballPropertiesTest
{


	@Test
	public void testPropertiesCreation()
	{
		FootballProperties tmp = new FootballProperties();
		assertNotEquals(null, tmp);
		
		FootballProperties tmp_two = new FootballProperties(0.5,0.3);
		assertNotEquals(null, tmp_two);

		FootballProperties tmp_three = new FootballProperties(0.5,0.3,"Adidas");
		assertNotEquals(null, tmp_three);

		FootballProperties tmp_four = new FootballProperties(0.5,0.3,"Adidas",
				PhotoId.getFromInt(5));
		assertNotEquals(null, tmp_four);
	
	}
	
}
