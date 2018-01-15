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
	
	private Football m_football;
	
	/**
	 * @methodtype constructor
	 * Default
	 */
	
	public FootballPhoto() {
		
		super();	
	}
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public FootballPhoto(Football football) {
		
		this();
		m_football = football;
	}

	/**
	 * @methodtype constructor
	 * 
	 */
	public FootballPhoto(PhotoId id) {
		
		super(id);
	}
	
	/**
	 * @methodtype constructor
	 * 
	 */
	public FootballPhoto(PhotoId id, Football football) {
		
		this(id);
		m_football = football;
	}

//-----------------Getter&Setter-----------------------------------------------
	
	/**
	 * @methodtype get
	 */
	public Football getFootball()
	{
		return m_football;
	}
	
	/**
	 * @methodtype set
	 * 
	 * */
	public void setProperties(Football football)
	{
		m_football = football;
	}
}
