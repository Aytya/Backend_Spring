package com.example.project.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "exam-list")
public class ExamList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean feeSubmitted;
    private String studentName;
    private String semester;
    private String department;
    private String courseCode;
    private String status;
    private String exam;
    private Integer examResult;
    private String listDate;
}
