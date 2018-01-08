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

import java.util.logging.Logger;

import org.wahlzeit.annotation.PatternInstance;

/**
 * A photo represents a user-provided (uploaded) photo.
 */
@PatternInstance (
	name 		 = "Abstract Factory",
	participants = "ConcreteFactory"
)
public class FootballPhotoFactory extends PhotoFactory
{
	
	private static final Logger log = Logger.getLogger(FootballPhotoFactory.class.getName());
	
	private static FootballPhotoFactory instance = null;
	
	public static synchronized FootballPhotoFactory getInstance() {
		
		if (null == instance)
		{
			instance = new FootballPhotoFactory();
		}
		return instance;		
	}
	/*
	 * @methodtype factory
	 * 
	 * Create new Photos with different Properties
	 * 
	 * */
	
	public FootballPhoto createPhoto() 
	{
		return new FootballPhoto();
	}
	
	
	public FootballPhoto createPhoto(PhotoId id) 
	{
		return new FootballPhoto(id);
	}
	
	public FootballPhoto createPhoto(PhotoId id, FootballProperties props) 
	{
		return new FootballPhoto(id, props);
	}
	
	public FootballPhoto createPhoto(FootballProperties props) 
	{
		return new FootballPhoto(props);
	}

//----------------------------------------------------End of methodtype factory --------------------------------
	
	
	

}
