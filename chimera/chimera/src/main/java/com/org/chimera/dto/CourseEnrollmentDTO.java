package com.org.chimera.dto;



import java.io.Serializable;
import java.time.LocalDate;

public class CourseEnrollmentDTO implements Serializable {

    private Long courseId;
    private String courseName;
    private LocalDate enrollmentDate;

    public CourseEnrollmentDTO(Long courseId, String courseName, LocalDate enrollmentDate) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrollmentDate = enrollmentDate;
    }

    // Getters and Setters
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}

