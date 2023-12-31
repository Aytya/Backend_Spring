package com.example.project.controller;

import com.example.project.model.FeeRecord;
import com.example.project.repository.AccountingRepository;
import com.example.project.repository.FeeRecordRepository;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounting")
public class AccountingController {

    @Autowired
    FeeRecordRepository feeRecordRepository;

    @GetMapping("/gross-income")
    @PreAuthorize("hasRole('ADMIN')")
    public Integer getGrossIncome(){
        return feeRecordRepository.getGrossIncome();
    }

    @GetMapping("/gross-income/{startDate}/{endDate}")
    public Integer getGrossIncomeByDate(@PathVariable String startDate,@PathVariable String endData) {
        return feeRecordRepository.getGrossIncomeByDate(startDate, endData);
    }

    @GetMapping("/get-net-income")
    public Integer getNetIncome(){
        return feeRecordRepository.getNetIncome();
    }

    @GetMapping("/students")
    public Page<FeeRecord> getAllStudents(Pageable pageable){
        return feeRecordRepository.getAllStudents(pageable);
    }
}
