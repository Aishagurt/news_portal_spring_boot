package kz.bitlab.techboot.springsecurityboot.mapper;


import kz.bitlab.techboot.springsecurityboot.dto.CourseDTO;
import kz.bitlab.techboot.springsecurityboot.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "name", target = "courseName")
    CourseDTO toDto(Course course);

    @Mapping(source = "courseName", target = "name")
    Course toModel(CourseDTO courseDTO);

    List<CourseDTO> toDtoList(List<Course> courseList);
    List<Course> toModelList(List<CourseDTO> courseList);

}
