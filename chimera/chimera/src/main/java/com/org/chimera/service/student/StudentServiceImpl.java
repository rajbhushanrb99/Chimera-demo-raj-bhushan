package com.org.chimera.service.student;

import com.org.chimera.entity.Student;
import com.org.chimera.exceptions.StudentNotFoundException;
import com.org.chimera.repository.CourseRepository;
import com.org.chimera.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found having id "+id));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student updatedStudent = existingStudent.get();
            updatedStudent.setName(student.getName());
            return studentRepository.save(updatedStudent);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }
}

