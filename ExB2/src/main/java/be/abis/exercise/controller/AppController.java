package be.abis.exercise.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import be.abis.exercise.model.Course;
import be.abis.exercise.model.CourseOption;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Password;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.PersonRepository;
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
	
	@Autowired
	PersonRepository personRepository;
	
	Person p;
	
	List<Course> courses;
	public String sI;
	public String sA;
	public String eMail;
	
	
	//login
	@GetMapping("/")
	public String loginForm(Model model){
		Login loggedInPerson  = new Login(); 
		model.addAttribute("login", loggedInPerson);
		return "login";
	}
	
	@PostMapping("/")
	public String welcome(Model model, Login login) {
		this.p = personservice.findPerson(login.getEmailAddress(), login.getPassword());
		this.eMail = login.getEmailAddress();
	    return "redirect:/welcome";
	}
	//end
	
	//welcome
	@GetMapping("/welcome")
	public String welcomeForm(Model model){
		model.addAttribute("firstname", this.p.getFirstName());
		return "welcome";
	}

	
	@PostMapping("/welcome")
	public String login(Model model) {
		
	    return "redirect:/";
	}
	
	// courses
	@PostMapping("/doCourses")
	public String docourses(Model model) {
		CourseOption courseOption = new CourseOption();
		model.addAttribute("courseOption", courseOption);
	    return "searchcourse";
	}
	
	
	@PostMapping("/searchCourse")
	public String searchcourses(Model model, CourseOption courseOption) {
		
		sI = courseOption.getSelectedItem(); 
		sA = courseOption.getSelectedArgument();
		
		System.out.println("Selected Item: " + sI);
		System.out.println("Selected Argument: " + sA);
		
		switch(sI) {
		case "all":
			courses = this.courseservice.findAllCourses();
			System.out.println("size of list: " + courses.size());
			model.addAttribute("courses", courses);
			break;
		case "byid":
			courses.clear();
			courses.add(this.courseservice.findCourse(Integer.parseInt(sA)));
			System.out.println("size of list: " + courses.size());
			model.addAttribute("courses", courses);
			break;
		case "bystitle":
			courses.clear();
			courses.add(this.courseservice.findCourse(sA));
			System.out.println("size of list: " + courses.size());
			model.addAttribute("courses", courses);
			break;
		default: 
			//
			
		}
	
	    return "searchcourse";
	    
	}    
	//end
	
	//person administration
	@PostMapping("/doAdmin")
	public String doaAmin(Model model) {
		System.out.println("doAdmin post bereikt");
		return "personadmin";
	}
	//end
	
	// get en post voor change password
	@GetMapping("/doPw")
	public String doaPw(Model model) {
		System.out.println("doPw get bereikt");
		Password newPassword  = new Password(); 
		model.addAttribute("password1", newPassword);
		return "changepw";
	}
	@PostMapping("/changePw")
	public String changepw(Model model, Password newPassword) throws IOException {
		System.out.println("changePw post bereikt");
		System.out.println("new password : " + newPassword.getNewPassword());
	    this.personRepository.changePassword(p, newPassword.getNewPassword());
	    return "personadmin";
	}
	// end
	
	@GetMapping("/doShowPersons")
	public String doShoxPersons(Model model) {
		return "showpersons";
	}
	@GetMapping("/doAddP")
	public String doAddP(Model model) {
		return "addperson";
	}
	@GetMapping("/doRemoveP")
	public String doRemoveP(Model model) {
		return "removeperson";
	}
		
	
	
	
	
	

}
