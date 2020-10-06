package be.abis.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import be.abis.exercise.model.Course;
import be.abis.exercise.service.CourseService;

@Controller
public class AppController {
	
	@Autowired
	CourseService courseservice;
	
	@GetMapping("/")
	public String showCourse(Model model) {
		Course c = courseservice.findCourse(7900);
		return "exercise";
	}

}
