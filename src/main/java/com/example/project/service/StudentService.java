package com.example.project.service;

import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.User;

import java.util.List;

public interface StudentService {

    List<User> getAllStudents();

    User saveStudent(User student) throws ResourceAlreadyExistsException;

    User getStudentById(Integer id) throws ResourceDoesNotExistException;

    User updateStudent(User student);

    void deleteStudentById(Integer id) throws ResourceDoesNotExistException;
}
