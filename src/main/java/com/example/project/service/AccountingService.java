package com.example.project.service;

import com.example.project.model.AccountingRecord;
import com.example.project.repository.AccountingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountingService {

//    @Autowired
//    private AccountingRepository accountingRepository;
//
//    public List<AccountingRecord> getAllStudentsFeeRecord() {
//        List<AccountingRecord> accountingRecordList = new ArrayList<>();
//        accountingRecordList.addAll((Collection<? extends AccountingRecord>) accountingRepository.findAll());
//        return accountingRecordList;
//    }
}
