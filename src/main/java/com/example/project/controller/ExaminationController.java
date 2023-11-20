package com.example.project.controller;

import com.example.project.model.ExamList;
import com.example.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/examination/")
public class ExaminationController {

    @Autowired
    ExamListRepository examListRepository;


    @GetMapping("/add")
    public ExamList save(ExamList examList) {
        return examListRepository.save(examList);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        examListRepository.deleteById(id);
    }
}
