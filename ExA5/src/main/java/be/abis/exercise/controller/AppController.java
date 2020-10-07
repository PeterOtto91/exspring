package be.abis.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import be.abis.exercise.model.Course;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.CourseService;
import be.abis.exercise.service.PersonService;
import be.abis.exercise.service.TrainingService;

@Controller
public class AppController {
	
	@Autowired
	CourseService courseservice;
	
	@Autowired
	TrainingService trainingService;
	
	@Autowired
	PersonService personservice;
	
	@GetMapping("/")
	public String loginForm(Model model){
		Login loggedInPerson  = new Login(); 
		model.addAttribute("login", loggedInPerson);
		return "login";
	}
	
	@PostMapping("/login")
	public String welcome(Model model, Login login) {
		Person p = personservice.findPerson(login.getEmailAddress(), login.getPassword());
	    return "redirect :/welcome";
	}
	
	
	//@GetMapping("/")
	//public String printCourse(Model model){
	//	String title = trainingService.getCourseService().findCourse(7900).getShortTitle();
	//	model.addAttribute("coursetitle", title);
	//	return "course";
	//}
	
	//@GetMapping("/")
	//public String showCourse(Model model) {
	//	Course c = courseservice.findCourse(7900);
	//	model.addAttribute("course", c);
	//	return "course";
	//}

}
