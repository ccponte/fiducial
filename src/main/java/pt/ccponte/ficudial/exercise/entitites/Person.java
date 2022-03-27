package pt.ccponte.ficudial.exercise.entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity that represents a person
 * 
 * @author ccponte
 *
 */

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String personName;

	
	/**
	 * 
	 * Default constructor
	 * 
	 */
	public Person() {

	}
	
	/**
	 * Default constructor that sets the name attibute
	 * 
	 * @param personName Name attibute of a person object
	 */
	public Person(String personName) {
		this.personName = personName;
	}

	/**
	 * Returns the name attibute of a person object
	 * 
	 * @return The name attibute of a person object
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * Sets the name attibute of a person object
	 * 
	 * @param personName The name that will be set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

}
