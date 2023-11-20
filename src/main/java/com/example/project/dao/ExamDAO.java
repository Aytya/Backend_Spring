package com.example.project.dao;

import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.ExamList;
import com.example.project.repository.ExamListRepository;
import com.example.project.repository.GPARecordRepository;
import com.example.project.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamDAO implements ExamService {

    @Autowired
    private ExamListRepository exam;

    public ExamList save(ExamList examList) throws ResourceAlreadyExistsException {
        Optional<ExamList> examListOptional = exam.findById(examList.getId());
        if(examListOptional.isPresent()) {
            throw new ResourceAlreadyExistsException(examList.getId());
        } else {
            return exam.save(examList);
        }
    }

    @Override
    public void deleteById(Integer id) throws ResourceDoesNotExistException {
        Optional<ExamList> optionalExamList = exam.findById(id);
        optionalExamList.ifPresent(examList -> exam.deleteById(id));
        optionalExamList.orElseThrow(() -> new ResourceDoesNotExistException(id));
    }
}
