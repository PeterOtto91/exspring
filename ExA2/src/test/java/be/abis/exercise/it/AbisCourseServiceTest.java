package be.abis.exercise.it;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.abis.exercise.service.AbisCourseService;
import be.abis.exercise.service.CourseService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AbisCourseServiceTest {
	
	@Autowired
	CourseService courseService;
	
	@Before
	public void setUp() {
		courseService = new AbisCourseService();
	}
	
	@Test
	public void checkTitleOfCourse() {
		assertEquals("Workshop SQL", courseService.findCourse(7900).getShortTitle());
		System.out.println(courseService.findCourse(7900).getShortTitle());
	}

}
