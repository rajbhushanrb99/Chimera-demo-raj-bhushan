package com.org.chimera.specification;

import com.org.chimera.entity.StudentCourseEnrollment;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class StudentCourseEnrollmentSpecification {

    // Fetch students enrolled before the given date
    public static Specification<StudentCourseEnrollment> enrollBeforeDate(LocalDate date) {
        return (root, query, builder) -> builder.lessThan(root.get("enrollmentDate"), date);
    }

    // Fetch students enrolled after the given date
    public static Specification<StudentCourseEnrollment> enrollAfterDate(LocalDate date) {
        return (root, query, builder) -> builder.greaterThan(root.get("enrollmentDate"), date);
    }
}

