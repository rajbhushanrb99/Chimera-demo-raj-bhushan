package com.org.chimera.controller;

import com.org.chimera.dto.StudentCourseDTO;
import com.org.chimera.entity.StudentCourseEnrollment;
import com.org.chimera.service.enrolled.IStudentCourseEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/enrollment")
public class StudentCourseEnrollmentController {

    @Autowired
    private IStudentCourseEnrollmentService enrollmentService;

    @PostMapping("/{studentId}/enroll/{courseId}")
    public StudentCourseEnrollment enrollStudentInCourse(@PathVariable Long studentId,
                                                         @PathVariable Long courseId,
                                                         @RequestParam("date") String dateStr) {
        LocalDate enrollmentDate = LocalDate.parse(dateStr);
        return enrollmentService.enrollStudentInCourse(studentId, courseId, enrollmentDate);
    }

    @GetMapping("/students/enrolled-before")
    public List<StudentCourseDTO> getStudentsEnrolledBefore(@RequestParam("date") String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        return enrollmentService.getStudentsEnrolledBeforeDate(date);
    }

    @GetMapping("/students/enrolled-after")
    public List<StudentCourseDTO> getStudentsEnrolledAfter(@RequestParam("date") String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        return enrollmentService.getStudentsEnrolledAfterDate(date);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        enrollmentService.deleteStudent(id);
    }


    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        enrollmentService.deleteCourse(id);
    }
}

