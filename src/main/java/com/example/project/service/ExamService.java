package com.example.project.service;

import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.ExamList;
import com.example.project.repository.ExamListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ExamService{

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    ExamList save(ExamList examList) throws ResourceAlreadyExistsException;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    void deleteById(Integer id) throws ResourceDoesNotExistException;

}
