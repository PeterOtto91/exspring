package be.abis.exercise.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.abis.exercise.exception.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.PersonRepository;

@Service
public class AbisTrainingService implements TrainingService {
	
	@Autowired
	private PersonRepository pr;
	@Autowired
	private CourseService cs;
	
	@Override
	public Person findPerson(int id) {
		
		Person p = pr.findPerson(id);
		return p;
	}

	@Override
	public List<Person> showFollowedCourses() {
		
		List<Person> lp = pr.getAllPersons();
		return null;
	}

	@Override
	public void enrollForSession(Person person, Course course, LocalDate date) throws EnrollException {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public CourseService getCourseService() {
		return cs;
	}

}
