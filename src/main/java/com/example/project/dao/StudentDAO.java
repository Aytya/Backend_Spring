package com.example.project.dao;

import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import com.example.project.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentDAO implements StudentService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllStudents() {
        List<User> studentList = new ArrayList<>();
        studentList.addAll((Collection<? extends User>) userRepository.findAll());
        return studentList;
    }

    @Override
    public User saveStudent(User student) throws ResourceAlreadyExistsException {

        Optional<User> optionalStudent = userRepository.findById(student.getId());
        if(optionalStudent.isPresent()) {
            throw new ResourceAlreadyExistsException(student.getId());
        } else {
            return userRepository.save(student);
        }
    }

    @Override
    public User getStudentById(Integer id) throws ResourceDoesNotExistException {
        Optional<User> optionalStudent = userRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }else throw new ResourceDoesNotExistException(id);
    }

    @Override
    public User updateStudent(User student) {
        return userRepository.save(student);
    }

    @Override
    public void deleteStudentById(Integer id) throws ResourceDoesNotExistException{
        Optional<User> optionalStudent = userRepository.findById(id);
        optionalStudent.ifPresent(student -> userRepository.deleteById(id));
        optionalStudent.orElseThrow(() -> new ResourceDoesNotExistException(id));
    }

//    image
//    public String uploadImage(MultipartFile multipartFile) throws IOException {
//        Student student = studentRepository.save(studen)
//    }
}
