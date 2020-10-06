package be.abis.exercise.service;

import java.util.List;

import be.abis.exercise.model.Course;

public interface CourseService {
	
	List<Course> findAllCourses();
	
	Course findCourse(int id);
	
	Course findCourse(String shortTitle);
	
	

}
