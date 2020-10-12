package be.abis.exercise.service;

import java.time.LocalDate;
import java.util.List;

import be.abis.exercise.exception.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;

public interface TrainingService {
	
	
	Person findPerson(int id);
	List<Person> showFollowedCourses();
	public void enrollForSession(Person person, Course course, LocalDate date) throws EnrollException;
	public CourseService getCourseService();

}
