package com.org.chimera.service;


import com.org.chimera.entity.Student;
import com.org.chimera.repository.StudentRepository;
import com.org.chimera.service.student.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new Student();
        student.setId(1L);
        student.setName("Raj");
    }

    @Test
    void testSaveStudent() {
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        Student savedStudent = studentService.createStudent(student);
        assertEquals("Raj", savedStudent.getName());
    }

    @Test
    void testGetStudentById() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        Optional<Student> foundStudent = Optional.ofNullable(studentService.getStudent(1L));
        assertEquals("Raj", foundStudent.get().getName());
    }

    @Test
    void testUpdateStudent() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        Student updatedStudent = new Student();
        updatedStudent.setName("Raj Bhushan");
        when(studentRepository.save(any(Student.class))).thenReturn(updatedStudent);
        Student result = studentService.updateStudent(1L, updatedStudent);
        verify(studentRepository, times(1)).findById(1L);
        verify(studentRepository, times(1)).save(any(Student.class));
        assertEquals("Raj Bhushan", result.getName());
    }
    @Test
    void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById(1L);
        studentService.deleteStudent(1L);
        verify(studentRepository, times(1)).deleteById(1L);
    }
}

