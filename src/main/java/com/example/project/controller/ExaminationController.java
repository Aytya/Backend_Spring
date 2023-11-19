package com.example.project.controller;

import com.example.project.model.Student;
import com.example.project.repository.*;
import com.example.project.service.ProfessorService;
import com.example.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.desktop.UserSessionEvent;
import java.awt.print.Pageable;
import java.security.Principal;

@RestController
@RequestMapping("/api/v1/examination/")
public class ExaminationController {

    @Autowired
    private StudentService studentService;
    @Autowired
    ExamListRepository examListRepository;
    @Autowired
    GPARecordRepository gpaRecordRepository;
    @Autowired
    ProfessorService professorService;
    @Autowired
    AccountingRepository accountingRepository;

//    @RequestMapping("/student-result")
//    public String StudentResult(Model model, @RequestParam int page, RedirectAttributes redirectAttributes, Principal principal) {
//        model.addAttribute("title", "Student Result Page");
//        Pageable pageable = (Pageable) PageRequest.of(page, 10);
//        Page<Student> studentPage = this.studentService.getAllStudents(pageable);
//        model.addAttribute("currentPage",page);
//        return "examination/student-result-data";
//    }

    @RequestMapping("/semester")
    public String semester(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                           @RequestParam(value = "batch", required = false, defaultValue = "Bcs-17") String batch, Model model,
                           Principal principal) {
        model.addAttribute("title", "User Semester List Page");
        System.out.print(batch);
        model.addAttribute("batch", batch);
        return "examination/semester";
    }
}
