package com.example.project.dao;

import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.Student;
import com.example.project.repository.StudentRepository;
import com.example.project.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentDAO implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.addAll((Collection<? extends Student>) studentRepository.findAll());
        return studentList;
    }

    @Override
    public Student saveStudent(Student student) throws ResourceAlreadyExistsException {

        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if(optionalStudent.isPresent()) {
            throw new ResourceAlreadyExistsException(student.getId());
        } else {
            return studentRepository.save(student);
        }
    }

    @Override
    public Student getStudentById(Integer id) throws ResourceDoesNotExistException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }else throw new ResourceDoesNotExistException(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Integer id) throws ResourceDoesNotExistException{
        Optional<Student> optionalStudent = studentRepository.findById(id);
        optionalStudent.ifPresent(student -> studentRepository.deleteById(id));
        optionalStudent.orElseThrow(() -> new ResourceDoesNotExistException(id));
    }
}
