package com.example.studentgrades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.studentgrades.repository.StudentRepository;
import com.example.studentgrades.model.Student;
import com.example.studentgrades.model.Grade;


@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    @PostMapping("/")
    public String addStudent(@RequestParam("studentName") String studentName,
                             @RequestParam("subject") String subject,
                             @RequestParam("score") int score) {
        Student student = studentRepository.findByName(studentName)
                .orElse(new Student(studentName));
        student.addGrade(new Grade(subject, score));
        studentRepository.save(student);
        return "redirect:/";
    }
}
