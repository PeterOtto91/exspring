package be.abis.exercise.service;

import be.abis.exercise.model.Person;

public interface PersonService {
	
	Person findPerson(String emailAddress, String password);

}
