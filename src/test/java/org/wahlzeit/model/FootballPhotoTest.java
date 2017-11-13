package org.wahlzeit.model;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.testEnvironmentProvider.SysConfigProvider;
import org.wahlzeit.testEnvironmentProvider.UserServiceProvider;
import org.wahlzeit.testEnvironmentProvider.UserSessionProvider;

public class FootballPhotoTest
{
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
			outerRule(new LocalDatastoreServiceTestConfigProvider()).
			around(new RegisteredOfyEnvironmentProvider()).
			around(new SysConfigProvider()).
			around(new UserServiceProvider()).
			around(new UserSessionProvider());


	private static FootballProperties props_one;
	private static FootballProperties props_two;
	private static FootballProperties props_three;
	private static FootballProperties props_four;
	private static PhotoId id_one;
	private static PhotoId id_two;
	
	@BeforeClass
	public static void setUp() {
		
		props_one 	= new FootballProperties();
		props_two 	= new FootballProperties(0.5,0.3);
		props_three = new FootballProperties(1,1,"Adidas", "1975");
		props_four 	= new FootballProperties(0.2,0.4, "Nike");
		id_one 		= PhotoId.getIdFromInt(1);
		id_two		= PhotoId.getIdFromString("five");
	}
	
	
	@Test
	public void testFootballPhotoCreation() {
		
		FootballPhoto photo_one 	= new FootballPhoto();
		assertNotNull(photo_one);
		FootballPhoto photo_two 	= new FootballPhoto(props_one);
		assertNotNull(photo_two);
		FootballPhoto photo_three	= new FootballPhoto(id_one);
		assertNotNull(photo_three);
		FootballPhoto photo_four	= new FootballPhoto(id_one, props_two);
		assertNotNull(photo_four);
		
	}

	
	
	@Test
	public void testGetProperties() {
		FootballPhoto photo_two 	= new FootballPhoto(props_one);
		assertEquals(props_one, photo_two.getProperties());
		assertNotEquals(null, photo_two.getProperties());
		
		FootballPhoto photo_one 	= new FootballPhoto();
		assertEquals(null, photo_one.getProperties());
	}
	
	@Test
	public void testSetProperties() 
	{
		FootballPhoto photo_two 	= new FootballPhoto(props_four);
		photo_two.setProperties(props_four);
		assertEquals(props_four, photo_two.getProperties());
		
		assertNotEquals(props_one, photo_two.getProperties());
	}

}
