package pt.ccponte.ficudial.exercise;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pt.ccponte.ficudial.exercise.controllers.PersonController;
import pt.ccponte.ficudial.exercise.entitites.Person;
import pt.ccponte.ficudial.exercise.services.PersonService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class FiducialApplicationTests {

	@Autowired
	private PersonController personController;
	
	@Autowired
	private PersonService personService;
	
	private String names = "[\"Jacob\", \"Michael\", \"Matthew\", \"Joshua\", \"Christopher\", \"Nicholas\", \"Andrew\",\"Joseph\", \"Daniel\", \"Tyler\", \"William\", \"Brandon\", \"Ryan\", \"John\", \"Zachary\", \"David\", \"Anthony\",\"James\", \"Justin\", \"Alexander\", \"Jonathan\"]";

	@Test
	@Order(1)
	void insertName() {
		List<Person> namesList = personService.getPersonList(this.names);
		List<Person> returnedNamesList = personController.saveAllNames(names.toString());

		Assertions.assertEquals(namesList.size(), returnedNamesList.size());
	}

	@Test
	@Order(2)
	void listNames() {
		List<Person> namesList = personService.getPersonList(this.names);
		List<String> returnedNamesList = personController.getAllNames();

		Assertions.assertEquals(namesList.size(), returnedNamesList.size());
	}

	@Test
	@Order(3)
	void getNameByName() {
		Assertions.assertEquals(true, personController.getName("Jacob"));
		Assertions.assertEquals(false, personController.getName("Clayton"));
	}

}