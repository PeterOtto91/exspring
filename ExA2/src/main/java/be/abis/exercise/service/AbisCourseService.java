package be.abis.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.MemoryCourseRepository;

@Service
public class AbisCourseService implements CourseService {
	
	@Autowired
	MemoryCourseRepository m;
	
	@Override
	public List<Course> findAllCourses() {
		List<Course> l = m.findAllCourses();
		return l;
	}
	
	@Override
	public Course findCourse(int id) {
		
		Course c = m.findCourse(id);
		// logic to read file
		return c;
	}
	
	@Override
	public Course findCourse(String shortTitle) {
		Course c = m.findCourse(shortTitle);
		return c;
	}
		

}
