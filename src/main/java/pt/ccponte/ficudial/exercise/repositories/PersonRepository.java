package pt.ccponte.ficudial.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pt.ccponte.ficudial.exercise.entitites.Person;


/**
 * Repository interface for database actions
 * 
 * @author ccponte
 *
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	/**
	 * Searches a name in the database
	 * 
	 * @param name Name to be searched in the database
	 * @return A boolean value that indicates if the name exists or doesn't 
	 * exist in the database
	 */
	boolean existsPersonByPersonName(String name);
	
}
