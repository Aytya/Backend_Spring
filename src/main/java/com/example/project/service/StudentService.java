package com.example.project.service;

import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student) throws ResourceAlreadyExistsException;

    Student getStudentById(Integer id) throws ResourceDoesNotExistException;

    Student updateStudent(Student student);

    void deleteStudentById(Integer id) throws ResourceDoesNotExistException;
}
