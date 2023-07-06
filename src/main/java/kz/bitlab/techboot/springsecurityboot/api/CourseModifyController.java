package kz.bitlab.techboot.springsecurityboot.api;

import kz.bitlab.techboot.springsecurityboot.dto.CourseDTO;
import kz.bitlab.techboot.springsecurityboot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/add")
@RequiredArgsConstructor
public class CourseModifyController {

    private final CourseService courseService;

    @PostMapping(value = "/course")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public CourseDTO addCourse(@RequestBody CourseDTO course){
        return courseService.addCourse(course);
    }


}
