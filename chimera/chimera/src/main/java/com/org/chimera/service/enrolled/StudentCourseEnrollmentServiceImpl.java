package com.org.chimera.service.enrolled;

import com.org.chimera.dto.CourseEnrollmentDTO;
import com.org.chimera.dto.StudentCourseDTO;
import com.org.chimera.entity.Course;
import com.org.chimera.entity.Student;
import com.org.chimera.entity.StudentCourseEnrollment;
import com.org.chimera.repository.CourseRepository;
import com.org.chimera.repository.StudentCourseRepository;
import com.org.chimera.repository.StudentRepository;
import com.org.chimera.specification.StudentCourseEnrollmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentCourseEnrollmentServiceImpl implements IStudentCourseEnrollmentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseRepository enrollmentRepository;

    public StudentCourseEnrollment enrollStudentInCourse(Long studentId, Long courseId, LocalDate enrollmentDate) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        StudentCourseEnrollment enrollment = new StudentCourseEnrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(enrollmentDate);
        studentRepository.save(student);
        return enrollmentRepository.save(enrollment);

    }

    public List<StudentCourseDTO> getStudentsEnrolledBeforeDate(LocalDate date) {
        //List<StudentCourseEnrollment> enrollments = enrollmentRepository.findByEnrollmentDateBefore(date);
        Specification<StudentCourseEnrollment> specification = StudentCourseEnrollmentSpecification.enrollBeforeDate(date);
        List<StudentCourseEnrollment> enrollments = enrollmentRepository.findAll(specification);
        return mapStudentCourseEnrollmentToStudent(enrollments);

    }

    // Get students enrolled after a specific date
    public List<StudentCourseDTO> getStudentsEnrolledAfterDate(LocalDate date) {
        //List<StudentCourseEnrollment> enrollments = enrollmentRepository.findByEnrollmentDateAfter(date);
        Specification<StudentCourseEnrollment> specification = StudentCourseEnrollmentSpecification.enrollAfterDate(date);
        List<StudentCourseEnrollment> enrollments = enrollmentRepository.findAll(specification);
        return mapStudentCourseEnrollmentToStudent(enrollments);
    }

    private List<StudentCourseDTO> mapStudentCourseEnrollmentToStudent(List<StudentCourseEnrollment> enrollments) {
        Map<Student, List<CourseEnrollmentDTO>> studentCoursesMap = enrollments.stream()
                .collect(Collectors.groupingBy(StudentCourseEnrollment::getStudent,
                        Collectors.mapping(enrollment -> new CourseEnrollmentDTO(
                                enrollment.getCourse().getId(),
                                enrollment.getCourse().getName(),
                                enrollment.getEnrollmentDate()), Collectors.toList())));
        return studentCoursesMap.entrySet().stream()
                .map(entry -> new StudentCourseDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}

