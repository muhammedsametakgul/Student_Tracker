package com.samet.student_tracker.service;

import com.samet.student_tracker.dao.StudentRepository;
import com.samet.student_tracker.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> result = studentRepository.findById(theId);

        Student theStudent=null;
        if(result.isPresent()){
            theStudent=result.get();
        }else{
            throw new RuntimeException("did not find student id " + theId);
        }
        return theStudent;
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }
}
