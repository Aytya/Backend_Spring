package com.example.project.repository;

import com.example.project.model.AccountingRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

public interface AccountingRepository extends JpaRepository<AccountingRecord, Integer> {
//    public Integer getTotalRegistrationFee();
//
//    public AccountingRecord getAllStudentsFeeRecordBySemester( String type, String semester, int id);
//
//    public Integer getTotalRegistrationFeeByDate( Date startDate, Date endDate);
//
//    public Integer getTotalSemesterFee();
//
//    public Integer getTotalSemesterFeeByDate( Date startDate, Date endDate);
//
//    public int updateFeeRecord(int submitAmount, int id);
//
//    public Page<AccountingRecord> getAllStudentsFeeRecord(Pageable pageable, String batch, String semester);
//
//    public List<AccountingRecord> findByNameContaining(String name, String semester);

}
