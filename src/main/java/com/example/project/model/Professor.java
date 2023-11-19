package com.example.project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "professor")
public class Professor {

    @Id
    @Column(name = "professor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "professor_name")
    private String name;
    @Column(name = "professor_qualification")
    private String qualification;
    @Column(name = "professor_dep")
    private String department;
}
