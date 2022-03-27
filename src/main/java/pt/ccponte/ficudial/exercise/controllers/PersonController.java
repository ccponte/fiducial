package pt.ccponte.ficudial.exercise.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.ccponte.ficudial.exercise.entitites.Person;
import pt.ccponte.ficudial.exercise.services.PersonService;


/**
 * This controller provides the endpoints to handle the names in the database
 * 
 * @author ccponte
 *
 */

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	
	/**
	 * Endpoint to include a list of names sent in a json String
	 * 
	 * @param namesList A json string containing a list of names
	 * @return A List of Person containing all names that were successfully included
	 * 
	 */
	@PostMapping("/saveAllNames")
	public List<Person> saveAllNames(@RequestBody String namesList) {
		return personService.saveName(namesList);
	}
	
	/**
	 * Endpoint that returns all names exist in the database
	 * 
	 * @return A List of String containing all names that exist in the database
	 * 
	 */
	@GetMapping("/getAllNames")
	public List<String> getAllNames() {
		return personService.getAllNames();
	}
	
	/**
	 * Endpoint that verifies if a given name exists in the database and returns
	 * true if it exists or false if it doesn't exist 
	 * 
	 * @param name A name to be searched in the database
	 * @return A boolean value that indicates if the name exists or doesn't 
	 * exist in the database
	 */
	@GetMapping("/getName")
	public boolean getName(@RequestParam(value = "name", defaultValue = "") String name) {
		return personService.getPersonByName(name) ;
	}
	
}