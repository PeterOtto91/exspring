package be.abis.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.abis.exercise.model.Person;
import be.abis.exercise.repository.PersonRepository;

@Service
public class AbisPersonService implements PersonService{
	
	@Autowired
	private PersonRepository pr;

	@Override
	public Person findPerson(String emailAddress, String password) {
			Person p = pr.findPerson(emailAddress, password);
			return p;

	}

}
