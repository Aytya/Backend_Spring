package com.example.project.service;

import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.Course;
import com.example.project.model.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {

    Professor save(Professor professor) throws ResourceAlreadyExistsException;
    Professor get(int id) throws ResourceDoesNotExistException;
    List<Professor> getAll();
    void delete (int id) throws ResourceDoesNotExistException;
    List<Professor> search(String keyword);
    Professor update(Professor professor);
}
