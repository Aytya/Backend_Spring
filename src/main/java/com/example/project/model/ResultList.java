package com.example.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "result-list")
public class ResultList {

    @Id
    @GeneratedValue
    private int id;
    private String date;
    private String rollNo;
    private String studentName;
    private String semester;
    private String department;
    private int marks;
    private float value;
    private String status;
    private int totalMarks;
}
