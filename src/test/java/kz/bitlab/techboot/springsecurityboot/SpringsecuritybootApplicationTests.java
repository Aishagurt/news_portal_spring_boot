//package kz.bitlab.techboot.springsecurityboot;
//
//import kz.bitlab.techboot.springsecurityboot.mapper.PostMapper;
//import kz.bitlab.techboot.springsecurityboot.model.Post;
//import kz.bitlab.techboot.springsecurityboot.repository.PostRepository;
//import kz.bitlab.techboot.springsecurityboot.service.PostService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class TestApp {
//
//	@Autowired
//	private PostMapper postMapper;
//
//	@Autowired
//	private PostService postService;
//
//	@Autowired
//		private PostRepository postRepository;
//
//	@Test
//	void checkPostDto(){
//
//		Post post = new Post();
//		post.setId(777L);
//		post.setTitle("News that are interesting");
//		post.setContent("Content of news that are very interesting");
//		post.setTags();
//
//		CourseDTO courseDTO = courseMapper.toDto(course);
//
//		Assertions.assertEquals(course.getName(), courseDTO.getCourseName());
//		Assertions.assertEquals(course.getId(), courseDTO.getId());
//		Assertions.assertEquals(course.getDescription(), courseDTO.getDescription());
//		Assertions.assertEquals(course.getPrice(), courseDTO.getPrice());
//
//	}
//
//	@Test
//	void checkInsertIntoDb(){
//
//		courseRepository.deleteAll();
//
//		String courseName = "Java EE";
//		String courseDescription = "Java EE";
//		int coursePrice = 7777;
//
//		Course course = new Course();
//		course.setName(courseName);
//		course.setDescription(courseDescription);
//		course.setPrice(coursePrice);
//
//		CourseDTO newCourse = courseService.addCourse(courseMapper.toDto(course));
//
//		Assertions.assertNotNull(newCourse);
//		Assertions.assertNotNull(newCourse.getId());
//		Assertions.assertEquals(courseName, newCourse.getCourseName());
//		Assertions.assertEquals(coursePrice, newCourse.getPrice());
//		Assertions.assertEquals(courseDescription, newCourse.getDescription());
//
//		courseRepository.deleteAll();
//
//	}
//
//}
