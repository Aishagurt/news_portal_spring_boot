package kz.bitlab.techboot.springsecurityboot;

import kz.bitlab.techboot.springsecurityboot.dto.CourseDTO;
import kz.bitlab.techboot.springsecurityboot.mapper.CourseMapper;
import kz.bitlab.techboot.springsecurityboot.model.Course;
import kz.bitlab.techboot.springsecurityboot.repository.CourseRepository;
import kz.bitlab.techboot.springsecurityboot.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApp {

	@Autowired
	private CourseMapper courseMapper;

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseRepository courseRepository;

	@Test
	void checkCourseDto(){

		Course course = new Course();
		course.setId(777L);
		course.setName("Java EE");
		course.setDescription("Some Java EE Course");
		course.setPrice(8888);

		CourseDTO courseDTO = courseMapper.toDto(course);

		Assertions.assertEquals(course.getName(), courseDTO.getCourseName());
		Assertions.assertEquals(course.getId(), courseDTO.getId());
		Assertions.assertEquals(course.getDescription(), courseDTO.getDescription());
		Assertions.assertEquals(course.getPrice(), courseDTO.getPrice());

	}

	@Test
	void checkInsertIntoDb(){

		courseRepository.deleteAll();

		String courseName = "Java EE";
		String courseDescription = "Java EE";
		int coursePrice = 7777;

		Course course = new Course();
		course.setName(courseName);
		course.setDescription(courseDescription);
		course.setPrice(coursePrice);

		CourseDTO newCourse = courseService.addCourse(courseMapper.toDto(course));

		Assertions.assertNotNull(newCourse);
		Assertions.assertNotNull(newCourse.getId());
		Assertions.assertEquals(courseName, newCourse.getCourseName());
		Assertions.assertEquals(coursePrice, newCourse.getPrice());
		Assertions.assertEquals(courseDescription, newCourse.getDescription());

		courseRepository.deleteAll();

	}

}
