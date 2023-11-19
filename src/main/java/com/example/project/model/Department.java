package com.example.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="department")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    @Id
    @Column(name = "departmentId")
    String departmentId;

    @Column(name = "departmentName")
    String departmentName;

    @Column(name = "noofEmployee")
    String noOfEmployee;

    @Column(name = "managerId")
    String managerId;

}
