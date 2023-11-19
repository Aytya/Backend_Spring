package com.example.project.repository;

import com.example.project.model.AccountingRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import java.sql.Date;
import java.util.List;

public interface AccountingRepository extends JpaRepository<AccountingRecord, Integer> {
    @Query("SELECT SUM(totalAmount) FROM AccountingRecord where type = 'Registration Fee'")
    public Integer getTotalRegistrationFee();

    @Query("select a from AccountingRecord a where a.type = :type AND a.semester = :semester AND a.studentId.id = :id")
    public AccountingRecord getAllStudentsFeeRecordByRollNoAndSemester(@Param(value="type") String type, @Param(value="semester") String semester, @Param(value="id") int id);

    @Query("SELECT SUM(totalAmount) FROM AccountingRecord where type = 'Registration Fee' AND date BETWEEN :startDate AND :endDate")
    public Integer getTotalRegistrationFeeByDate(@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    @Query("SELECT SUM(totalAmount) FROM AccountingRecord where type = 'Semester Fee'")
    public Integer getTotalSemesterFee();

    @Query("SELECT SUM(totalAmount) FROM AccountingRecord where type = 'Semester Fee' AND date BETWEEN :startDate AND :endDate")
    public Integer getTotalSemesterFeeByDate(@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    @Modifying
    @Query("update AccountingRecord a set a.submitAmount = :submitAmount WHERE a.accountId = :id ")
    public int updateFeeRecord(@Param(value="submitAmount")int submitAmount,@Param(value="id") int id);

    @Query("select a from AccountingRecord a where a.semester = :semester order by a.date desc")
    public Page<AccountingRecord> getAllStudentsFeeRecord(Pageable pageable, @Param(value="batch") String batch, @Param(value="semester") String semester);

    @Query("SELECT a FROM AccountingRecord a WHERE a.studentId.firstName LIKE :name AND a.semester = :semester OR a.studentId.lastName LIKE :name AND a.semester = :semester")
    public List<AccountingRecord> findByNameContaining(@Param("name")String name, @Param("semester")String semester, @Param("batch")String batch);

}
