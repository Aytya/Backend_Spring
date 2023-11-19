package com.example.project.repository;

import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.ExamList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

//@Api(tags = {"exams"})
public interface ExamListRepository extends JpaRepository<ExamList, Integer> {

}
