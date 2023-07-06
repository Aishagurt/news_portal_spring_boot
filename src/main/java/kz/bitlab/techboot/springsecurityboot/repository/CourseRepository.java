package kz.bitlab.techboot.springsecurityboot.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.techboot.springsecurityboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, Long> {
}