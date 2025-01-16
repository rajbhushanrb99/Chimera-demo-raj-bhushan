package com.org.chimera.controller;

import com.org.chimera.entity.Student;
import com.org.chimera.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping(value = "createStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping("getStudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("getAllStudent")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("deleteStudent/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    // Find students enrolled before a specific date
//    @GetMapping("/enrolled-before")
//    public ResponseEntity<List<Student>> findStudentsEnrolledBefore(@RequestParam("date") String dateString) {
//        LocalDate date = LocalDate.parse(dateString);
//        List<Student> students = studentService.findStudentsEnrolledBefore(date);
//        return ResponseEntity.ok(students);
//    }
}
