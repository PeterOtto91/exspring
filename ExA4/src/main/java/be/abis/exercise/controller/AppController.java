package be.abis.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import be.abis.exercise.model.Course;
import be.abis.exercise.service.CourseService;
import be.abis.exercise.service.TrainingService;

@Controller
public class AppController {
	
	@Autowired
	CourseService courseservice;
	
	@Autowired
	TrainingService trainingService;
	
	@GetMapping("/")
	public String printCourse(Model model){
		String title = trainingService.getCourseService().findCourse(7900).getShortTitle();
		model.addAttribute("coursetitle", title);
		return "course";
	}
	
	//@GetMapping("/")
	//public String showCourse(Model model) {
	//	Course c = courseservice.findCourse(7900);
	//	model.addAttribute("course", c);
	//	return "course";
	//}

}
