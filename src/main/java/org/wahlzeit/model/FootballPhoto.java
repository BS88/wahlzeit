package org.wahlzeit.model;


import org.wahlzeit.annotation.PatternInstance;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;



/**
 * FootballPhoto represents a user-provided (uploaded) photo.
 */
@Entity
@Subclass(index = true)

@PatternInstance (	
		name		 ="Abstract Factory",
		participants = "ConcretProdukt"
)
public class FootballPhoto extends Photo
{

//--------------------------Ctors----------------------------------------------
	
	private FootballProperties m_properties = null;
	
	/**
	 * @methodtype constructor
	 * Default
	 */
	
	public FootballPhoto() 
	{
		super();	
	}
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public FootballPhoto(FootballProperties props) 
	{
		this();
		m_properties = props;
	}

	/**
	 * @methodtype constructor
	 * 
	 */
	public FootballPhoto(PhotoId id) 
	{
		super(id);
	}
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public FootballPhoto(PhotoId id, FootballProperties props) 
	{
		this(id);
		m_properties = props;
	}

//-------------------------------Getter&Setter---------------------------------
	
	/**
	 * @methodtype get
	 */
	public FootballProperties getProperties()
	{
		return m_properties;
	}
	
	/**
	 * @methodtype set
	 * 
	 * */
	public void setProperties(FootballProperties props)
	{
		this.m_properties = props;
	}
	
}
