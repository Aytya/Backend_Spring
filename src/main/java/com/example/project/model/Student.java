package com.example.project.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "students")
public class Student implements Serializable {

    @Column(name = "student_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;
    public String firstName;
    public String lastName;
    @Nullable
    public String department;
    @Nullable
    public String program;
    @Nullable
    public String yearOfSubmission;
    @Nullable
    public String dateOfBirth;
    @Column(unique = true)
    public String idNo;
    @Column(length = 1000)
    @Nullable
    public String permanentAddress;
    @Column(length = 1000)
    @Nullable
    public String maillingAddress;
    @Nullable
    public String phone;
    @Nullable
    public String email;
    @Nullable
    public String nationality;
    @Nullable
    public Date date;

}
