package com.samet.student_tracker.dao;

import com.samet.student_tracker.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
