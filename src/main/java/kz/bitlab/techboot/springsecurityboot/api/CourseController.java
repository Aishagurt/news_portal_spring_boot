package kz.bitlab.techboot.springsecurityboot.api;

import kz.bitlab.techboot.springsecurityboot.dto.CourseDTO;
import kz.bitlab.techboot.springsecurityboot.model.Course;
import kz.bitlab.techboot.springsecurityboot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping(value = "/get-course-list")
    public List<CourseDTO> getCourses(){
        return courseService.getCourses();
    }

    @PostMapping(value = "/add-course")
    public CourseDTO addCourse(@RequestBody CourseDTO course){
        return courseService.addCourse(course);
    }

}