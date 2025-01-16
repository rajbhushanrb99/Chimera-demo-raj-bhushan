package com.org.chimera.repository;

import com.org.chimera.entity.StudentCourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourseEnrollment, Long>, JpaSpecificationExecutor<StudentCourseEnrollment> {
    //List<StudentCourseEnrollment> findByEnrollmentDateBefore(LocalDate date);

   // List<StudentCourseEnrollment> findByEnrollmentDateAfter(LocalDate date);
}
