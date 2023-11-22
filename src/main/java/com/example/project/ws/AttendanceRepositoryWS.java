package com.example.project.ws;

import com.example.project.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepositoryWS extends JpaRepository<AttendanceStatus, Integer> {

}
