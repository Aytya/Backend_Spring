package com.example.project.repository;

import com.example.project.model.FeeRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FeeRecordRepository extends JpaRepository<FeeRecord,Integer> {

    @Query("select SUM(totalFee) from FeeRecord f")
    public Integer getGrossIncome();

    @Query("select SUM(totalFee) from FeeRecord f where f.feeSubmittedDate BETWEEN :startDate AND :endDate")
    public Integer getGrossIncomeByDate(@Param("startDate")String startDate,@Param("endDate")String endDate);

    @Query("select SUM (submittedFee) from FeeRecord f")
    public Integer getNetIncome();

    @Query("select s from FeeRecord s")
    public Page<FeeRecord> getAllStudents(Pageable pageable);

}