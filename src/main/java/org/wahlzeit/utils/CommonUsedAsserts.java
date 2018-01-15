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

package org.wahlzeit.utils;

import org.wahlzeit.services.DataObject;

public class CommonUsedAsserts extends DataObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void  assertIsNonNullObject(Object o, String message) {
		
		if (null == o ) {
			
			if (null != message)
				throw new IllegalArgumentException(message);
			else 
				throw new IllegalArgumentException();
		}
	}
	
	public static void assertIsValidDouble(double value ) {

		if (!Double.isFinite(value))
			throw new IllegalArgumentException("The given Value is not finite!");
		if (Double.isNaN(value))
			throw new IllegalArgumentException("The given Value is not a Number!");
	}	
}
