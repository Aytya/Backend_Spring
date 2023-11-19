package com.example.project.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"code"})
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;
    private String courseName;
    @Column(unique =true)
    private Integer courseCode;
    private String courseCreditHour;
    private String preRequisite;
    private String semester;
    private Date date;
}
