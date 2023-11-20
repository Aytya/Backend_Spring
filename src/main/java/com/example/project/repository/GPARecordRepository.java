package com.example.project.repository;

import com.example.project.model.GPARecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GPARecordRepository extends JpaRepository<GPARecord,Integer> {
//    public List<GPARecord> getAllGPARecordList();
    @Query("select g from GPARecord g where g.semester = :semester")
    public GPARecord getAllGPARecord(@Param("semester") String semester);

    @Query("update GPARecord g set g.GPA = :GPA where g.semester = :semester")
    public int updateGPARecord(float GPA, String semester);

    @Query("update GPARecord g set g.semesterCreditHour = :semesterCreditHour  WHERE g.semester = :semester")
    public int updateGPARecordCreditHour(@Param(value="semesterCreditHour") float semesterCreditHour, @Param(value="semester") String semester);
}