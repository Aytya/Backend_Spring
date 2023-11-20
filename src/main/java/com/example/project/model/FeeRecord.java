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
@Table(name = "fee-record")
public class FeeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String studentName;
    private String semester;
    private String department;
    private String feeType;
    @Column(length = 100)
    private int totalFee;
    @Column(length = 100)
    private int submittedFee;
    private String feeSubmittedDate;
    private float creditHour;
}
