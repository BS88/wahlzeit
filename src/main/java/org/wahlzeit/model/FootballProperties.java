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

import java.util.HashMap;

/*
 * 
 * */
public class FootballProperties
{
	// geometric Properties
	private double m_diameter = 0.0;
	private double m_weight    = 0.0;
	
	// 
	private String m_manufacturer = null;
	private String m_marketYear  = null;
	
	
	/*
	 * 
	 * */
	
	public FootballProperties() { }
	
	public FootballProperties (double diameter, double  weight) {
		m_diameter   = diameter;
		m_weight 		= weight;
	}
	public FootballProperties (double diameter, double weight, String manufacturer) {
		this(diameter, weight);
		m_manufacturer = manufacturer;
	}
	
	public FootballProperties (double diameter, double weight, String manufacturer, String marketYear) {
		
		this(diameter, weight, manufacturer);
		m_marketYear = marketYear;
	} 
	
public FootballProperties (String manufacturer, String marketYear) {
		
		this(0,0,manufacturer,marketYear);

	}

public double getDiameter()
{
	return m_diameter;
}

public double getWeight()
{
	return m_weight;
}

public String getManufacturer()
{
	return m_manufacturer;
}

public String getMarketYear()
{
	return m_marketYear;
}

public void setDiameter(double m_diameter)
{
	this.m_diameter = m_diameter;
}

public void setWeight(double m_weight)
{
	this.m_weight = m_weight;
}

public void setManufacturer(String m_manufacturer)
{
	this.m_manufacturer = m_manufacturer;
}

public void setMarketYear(String m_marketYear)
{
	this.m_marketYear = m_marketYear;
} 
		
}
