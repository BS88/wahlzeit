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
 * Football PhotManager subclass, a specific Photomanager
 */
@PatternInstance (
	name 		 = "Singelton",
	participants = {""}	
)
public class FootballPhotoManager extends PhotoManager
{
	/*-------------------------Member----------------------------------------*/
	private final static Logger log = Logger.getLogger(FootballPhotoManager.class.getName());
	
	protected static FootballPhotoManager instance = new FootballPhotoManager();
	

	protected FootballPhotoManager() 
	{
		super();
		photoTagCollector = FootballPhotoFactory.getInstance().createPhotoTagCollector();
	}
	public static FootballPhotoManager getInstance() 
	{
		if (instance == null) 
			instance = new FootballPhotoManager();
		return instance;
	}

	
}
