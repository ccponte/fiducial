package pt.ccponte.ficudial.exercise.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import pt.ccponte.ficudial.exercise.entitites.Person;
import pt.ccponte.ficudial.exercise.repositories.PersonRepository;

/**
 * Service that calls the database actions for each endpoint
 * 
 * @author ccponte
 *
 */

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	/**
	 * Inserts in the database a list of Person and returns the list of Person 
	 * that were successfully inserted
	 * 
	 * @param jsonNamesList A json string containing a list of names 
	 * @return List of Person containing all names that were successfully included
	 */
	public List<Person> saveName(String jsonNamesList) {
		return personRepository.saveAll(getPersonList(jsonNamesList));
	}
	
	/**
	 * Returns a List of Person containing all Person recorded in the database with
	 * no filters
	 * 
	 * @return List of String
	 */
	public List<String> getAllNames() {
		List<Person> returnedNameList = personRepository.findAll();

		return returnedNameList.stream().map(Person::getPersonName).collect(Collectors.toList());
	}
	
	/**
	 * Verifies if a given name exists in the database and returns true if it 
	 * exists or false if it doesn't exist 
	 * 
	 * @param name A name to be searched in the database
	 * @return A boolean value that indicates if the name exists or doesn't 
	 * exist in the database
	 */
	public boolean getPersonByName(String name) {
		return personRepository.existsPersonByPersonName(name);
	}
	
	/**
	 * Converts a json string containing a list of names to a List of Person
	 * 
	 * @param jsonNamesList A json string containing a list of names
	 * @return nameList
	 */
	public List<Person> getPersonList(String jsonNamesList) {
		List<Person> nameList = new ArrayList<>();
		
		JsonParser jsonParser = JsonParserFactory.getJsonParser();
		jsonParser.parseList(jsonNamesList).forEach(object -> nameList.add(new Person(object.toString())));
		
		return nameList;
	}
	
}
