package com.example.project.repository;

import com.example.project.model.GPARecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GPARecordRepository extends JpaRepository<GPARecord,Integer> {
    @Query("select g from GPARecord g where g.semester = :semester order by g.rollNo")
    public List<GPARecord> getAllGPARecordList(@Param("semester") String semester, @Param("batch") String batch);

    @Query("select g from GPARecord g where g.semester = :semester AND g.rollNo = :rollNo")
    public GPARecord getAllGPARecord(@Param("semester") String semester,@Param("rollNo") String rollNo);

    @Modifying
    @Query("update GPARecord g set g.GPA = :GPA WHERE g.rollNo = :rollNo")
    public int updateGPARecord(@Param(value="GPA") float GPA,@Param(value="CGPA") float CGPA, @Param(value="rollNo") String rollNo);

}