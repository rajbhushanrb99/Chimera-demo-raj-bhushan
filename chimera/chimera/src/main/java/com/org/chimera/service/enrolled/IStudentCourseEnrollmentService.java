package com.org.chimera.service.enrolled;

import com.org.chimera.dto.StudentCourseDTO;
import com.org.chimera.entity.StudentCourseEnrollment;

import java.time.LocalDate;
import java.util.List;

public interface IStudentCourseEnrollmentService {
    StudentCourseEnrollment enrollStudentInCourse(Long studentId, Long courseId, LocalDate enrollmentDate);

    public List<StudentCourseDTO> getStudentsEnrolledBeforeDate(LocalDate date);

    List<StudentCourseDTO> getStudentsEnrolledAfterDate(LocalDate date);

    void deleteStudent(Long studentId);

    void deleteCourse(Long courseId);
}
