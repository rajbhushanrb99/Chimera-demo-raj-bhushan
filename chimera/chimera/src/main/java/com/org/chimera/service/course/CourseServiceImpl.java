package com.org.chimera.service.course;

import com.org.chimera.entity.Course;
import com.org.chimera.exceptions.CourseNotFoundException;
import com.org.chimera.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found with Id "+id));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}

