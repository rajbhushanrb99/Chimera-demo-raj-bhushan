package com.org.chimera.dto;

import com.org.chimera.entity.Student;
import java.util.List;

public class StudentCourseDTO  {

    private Long studentId;
    private String studentName;
    private List<CourseEnrollmentDTO> courses;

    public StudentCourseDTO(Student student, List<CourseEnrollmentDTO> courses) {
        this.studentId = student.getId();
        this.studentName = student.getName();
        this.courses = courses;
    }

    // Getters and Setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<CourseEnrollmentDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEnrollmentDTO> courses) {
        this.courses = courses;
    }
}
