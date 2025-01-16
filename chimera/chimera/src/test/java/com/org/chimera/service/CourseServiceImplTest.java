package com.org.chimera.service;

import com.org.chimera.entity.Course;
import com.org.chimera.repository.CourseRepository;
import com.org.chimera.service.course.CourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    private Course course;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        course = new Course();
        course.setId(1L);
        course.setName("Java 101");
    }

    @Test
    void testSaveCourse() {
        when(courseRepository.save(any(Course.class))).thenReturn(course);
        Course savedCourse = courseService.createCourse(course);
        assertNotNull(savedCourse);
        assertEquals("Java 101", savedCourse.getName());
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void testGetCourseById() {
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        Optional<Course> foundCourse = Optional.ofNullable(courseService.getCourseById(1L));
        assertTrue(foundCourse.isPresent());
        assertEquals("Java 101", foundCourse.get().getName());
        verify(courseRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteCourse() {
        doNothing().when(courseRepository).deleteById(1L);
        courseService.deleteCourse(1L);
        verify(courseRepository, times(1)).deleteById(1L);
    }
}

