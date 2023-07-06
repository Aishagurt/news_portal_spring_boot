package kz.bitlab.techboot.springsecurityboot.service;

import kz.bitlab.techboot.springsecurityboot.dto.CourseDTO;
import kz.bitlab.techboot.springsecurityboot.mapper.CourseMapper;
import kz.bitlab.techboot.springsecurityboot.model.Course;
import kz.bitlab.techboot.springsecurityboot.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseDTO> getCourses(){
        return courseMapper.toDtoList(courseRepository.findAll());
    }

    public CourseDTO addCourse(CourseDTO course){
        return courseMapper.toDto(courseRepository.save(courseMapper.toModel(course)));
    }

    public CourseDTO getCourse(Long id){
        return courseMapper.toDto(courseRepository.findById(id).orElse(new Course()));
    }

    public CourseDTO updateCourse(CourseDTO course){
        return courseMapper.toDto(courseRepository.save(courseMapper.toModel(course)));
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

}
