package com.org.chimera.service.student;

import com.org.chimera.entity.Student;

import java.util.List;

public interface IStudentService {
    Student createStudent(Student student);

    Student getStudent(Long id);

    List<Student> getAllStudents();

    void deleteStudent(Long id);

    Student updateStudent(Long id, Student student);


}
