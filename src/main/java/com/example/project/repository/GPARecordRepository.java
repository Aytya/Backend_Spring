package com.example.project.repository;

import com.example.project.model.GPARecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GPARecordRepository extends JpaRepository<GPARecord,Integer> {
//    public List<GPARecord> getAllGPARecordList(String semester);
//
//    public GPARecord getAllGPARecord(String semester);
//
//    public int updateGPARecord(float GPA);

}