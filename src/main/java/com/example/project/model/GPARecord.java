package com.example.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "gpa")
public class GPARecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String semester;
    private float semesterCreditHour;
    private float GPA;
    private String rollNo;
}
