package com.org.chimera.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "course")
    private Set<StudentCourseEnrollment> studentCourses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StudentCourseEnrollment> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<StudentCourseEnrollment> studentCourses) {
        this.studentCourses = studentCourses;
    }
}

