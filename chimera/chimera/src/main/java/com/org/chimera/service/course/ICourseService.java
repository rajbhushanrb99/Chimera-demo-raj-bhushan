package com.org.chimera.service.course;

import com.org.chimera.entity.Course;

import java.util.List;

public interface ICourseService {
    Course createCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    void deleteCourse(Long id);
}
