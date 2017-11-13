package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FootballPhotoFactoryTest
{

	@Test
	public void getInstance()
	{
		FootballPhotoFactory factory = FootballPhotoFactory.getInstance();
		assertNotNull(factory);
	}

}
