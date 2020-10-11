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

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.CourseId;
import be.abis.exercise.model.CourseOption;
import be.abis.exercise.model.CourseTitle;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Password;
import be.abis.exercise.model.Person;
import be.abis.exercise.model.PersonId;
import be.abis.exercise.repository.CourseRepository;
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
	
	@Autowired
	CourseRepository courseRepository;
	
	public Person p;
	public Person p2;
	
	List<Course> courses;
	public String sI;
	public String sA;
	public String eMail;
	public List<Person> persons;
	Course course1;
	CourseId courseId2 = new CourseId();
	CourseTitle courseTitle2 = new CourseTitle();
	Company c1;
	
	
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
		System.out.println("doCourses post bereikt");
		return "courseaction";
	}
	
	@GetMapping("/allCourses")
	public String allcourses(Model model) {
		System.out.println("allCourses get bereikt");
		courses = this.courseservice.findAllCourses();
		model.addAttribute("courses", courses);
		return "allcourses";
	}
	
	@GetMapping("/idCourses")
	public String idCoursesForm(Model model){
		System.out.println("idcourses get bereikt");
	    System.out.println("courseid : " + courseId2.getCourseIdIn());
	    model.addAttribute("courseId1", courseId2);
	    return "idcourses";
	}
	
	@PostMapping("/idCourses")
	public String idcoursesForm(Model model, CourseId courseId1) {
		System.out.println("idcourses post bereikt");
		this.courseId2.setCourseIdIn(courseId1.getCourseIdIn());
	    return "redirect:/listcourses";
	}
	
	@GetMapping("/titleCourses")
	public String titleCoursesForm(Model model){
		System.out.println("titlecourses get bereikt");
	    System.out.println("coursetitle : " + courseTitle2.getCourseTitleIn());
	    model.addAttribute("courseTitle1", courseTitle2);
	    return "titlecourses";
	}
	
	@PostMapping("/titleCourses")
	public String titlecoursesForm(Model model, CourseTitle courseTitle1, Course course2) {
		System.out.println("titlecourses post bereikt");
		this.courseTitle2.setCourseTitleIn(courseTitle1.getCourseTitleIn());
	    return "redirect:/listcoursest";
	}
	
	@GetMapping("/listcourses")
	public String listCoursesForm(Model model){
		System.out.println("listcourses get bereikt");
	    System.out.println("courseid : " + courseId2.getCourseIdIn());
	    int cId1 = courseId2.getCourseIdIn();
	    Course course2 = this.courseRepository.findCourse(cId1);
	    model.addAttribute("course1", course2);
	    return "listcourses";
	}
	
	@GetMapping("/listcoursest")
	public String listCoursesTForm(Model model){
		System.out.println("listcourses get bereikt");
	    System.out.println("coursetitle : " + courseTitle2.getCourseTitleIn());
	    String cTitle1 = courseTitle2.getCourseTitleIn();
	    Course course2 = this.courseRepository.findCourse(cTitle1);
	    model.addAttribute("course1", course2);
	    return "listcoursest";
	}
	
	
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
	public String changepw(Model model, Password password1) throws IOException {
		System.out.println("changePw post bereikt");
		System.out.println("new password : " + password1.getNewPassword());
	    this.personRepository.changePassword(p, password1.getNewPassword());
	    return "personadmin";
	}
	// end
	
	@GetMapping("/doShowPersons")
	public String doShowPersons(Model model) {
		System.out.println("doShowPerson get bereikt");
		this.persons = this.personRepository.getAllPersons();
		model.addAttribute("persons", this.persons);
		return "showpersons";
	}
	@GetMapping("/doAddP")
	public String doAddP(Model model) {
		System.out.println("doAddP get bereikt");
		p2 = new Person();
		model.addAttribute("personNew", p2);
		return "addperson";
	}
	@PostMapping("/addPerson")
	public String addPerson(Model model, Person personNew) throws IOException {
		System.out.println("addPerson post bereikt");
		c1 = personNew.getCompany();
		Address ad1 = new Address();
		ad1.setStreet("Een Straat");
		ad1.setNr(15);
		ad1.setZipcode("2800");
		ad1.setTown("Mechelen");
		c1.setAddress(ad1);
		c1.setTelephoneNumber("475951636");
		c1.setVatNr("Be476258");
		personNew.setCompany(c1);
		System.out.println("company name: " + c1.getName());
		this.personRepository.addPerson(personNew);
	    return "personadmin";
	}
	
	
	
	@GetMapping("/doRemoveP")
	public String doRemoveP(Model model) {
		PersonId personId = new PersonId();
		model.addAttribute("personid1", personId);
		return "removeperson";
	}
		
	
	@PostMapping("/RemoveP")
	public String addPerson(Model model, PersonId personid1) throws IOException {
		System.out.println("removePerson post bereikt");
		this.personRepository.deletePerson(personid1.getpId());
	    return "personadmin";
	}
	
	
	
	

}
