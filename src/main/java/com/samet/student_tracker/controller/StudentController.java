package com.samet.student_tracker.controller;


import com.samet.student_tracker.entity.Student;
import com.samet.student_tracker.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Student student = new Student();

        theModel.addAttribute("student",student);

        return "/student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.save(student);

        return "redirect:/students/list";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int theId){
        studentService.deleteById(theId);

        return "redirect:/students/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId,Model theModel){
        Student student=studentService.findById(theId);

        theModel.addAttribute("student",student);

        return "student-form";
    }
}
