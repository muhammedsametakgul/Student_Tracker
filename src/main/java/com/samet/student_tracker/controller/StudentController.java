package com.samet.student_tracker.controller;


import com.samet.student_tracker.entity.Student;
import com.samet.student_tracker.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listStudents(Model theModel){
        List<Student> students = studentService.findAll();

        theModel.addAttribute("students",students);

        return "/list-students";
    }
}
