package com.example.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;
    private String semester;
    private String type;
    private String slipNumber;
    private int totalAmount;
    private int submitAmount;
    private Date date;
    @OneToOne
    public User studentId;
}
