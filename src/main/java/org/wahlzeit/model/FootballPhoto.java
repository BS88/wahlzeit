package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;



/**
 * FootballPhoto represents a user-provided (uploaded) photo.
 */
@Entity
@Subclass(index = true)
public class FootballPhoto extends Photo
{

	private FootballProperties m_properties = null;
	
	public FootballPhoto() 
	{
		super();	
	}
	
	public FootballPhoto(FootballProperties props) 
	{
		this();
		m_properties = props;
	}
	public FootballPhoto(PhotoId id) 
	{
		super(id);
	}
	public FootballPhoto(PhotoId id, FootballProperties props) 
	{
		this(id);
		m_properties = props;
	}
	/*
	 * @methodtype get
	 * 
	 * */
	public FootballProperties getProperties()
	{
		return m_properties;
	}
	
	/*
	 * @methodtype set
	 * 
	 * */
	public void setProperties(FootballProperties props)
	{
		this.m_properties = props;
	}
}
