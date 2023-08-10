package com.samet.student_tracker.service;

import com.samet.student_tracker.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int theId);

    void save(Student student);

    void deleteById(int theId);
}
