package com.org.chimera.service;


import com.org.chimera.dto.StudentCourseDTO;
import com.org.chimera.entity.Course;
import com.org.chimera.entity.Student;
import com.org.chimera.entity.StudentCourseEnrollment;
import com.org.chimera.repository.CourseRepository;
import com.org.chimera.repository.StudentCourseRepository;
import com.org.chimera.repository.StudentRepository;
import com.org.chimera.service.enrolled.StudentCourseEnrollmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentCourseEnrollmentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private StudentCourseRepository enrollmentRepository;

    @InjectMocks
    private StudentCourseEnrollmentServiceImpl enrollmentService;

    private Student student;
    private Course course;
    private StudentCourseEnrollment enrollment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        student = new Student();
        student.setId(1L);
        student.setName("John Doe");

        course = new Course();
        course.setId(1L);
        course.setName("Mathematics");

        enrollment = new StudentCourseEnrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.of(2022, 1, 1));
    }

    @Test
    void testEnrollStudentInCourse() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(enrollmentRepository.save(any(StudentCourseEnrollment.class))).thenReturn(enrollment);

        StudentCourseEnrollment enrolled = enrollmentService.enrollStudentInCourse(1L, 1L, LocalDate.now());

        verify(enrollmentRepository, times(1)).save(any(StudentCourseEnrollment.class));
        assertEquals(student, enrolled.getStudent());
        assertEquals(course, enrolled.getCourse());
    }

    @Test
    void testGetStudentsEnrolledBeforeDate() {
//        LocalDate date = LocalDate.of(2024, 01, 01);
//        when(enrollmentRepository.findByEnrollmentDateBefore(date)).thenReturn(List.of(enrollment));
//        List<StudentCourseDTO> result = enrollmentService.getStudentsEnrolledBeforeDate(date);
//        assertEquals(1, result.size());
    }

    @Test
    void testGetStudentsEnrolledAfterDate() {
//        LocalDate date = LocalDate.of(2024, 01, 11);
//        when(enrollmentRepository.findByEnrollmentDateAfter(date)).thenReturn(List.of(enrollment));
//        List<StudentCourseDTO> result = enrollmentService.getStudentsEnrolledAfterDate(date);
//        assertEquals(1, result.size());
    }

    @Test
    void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById(1L);
        enrollmentService.deleteStudent(1L);
        verify(studentRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteCourse() {
        doNothing().when(courseRepository).deleteById(1L);
        enrollmentService.deleteCourse(1L);
        verify(courseRepository, times(1)).deleteById(1L);
    }
}

