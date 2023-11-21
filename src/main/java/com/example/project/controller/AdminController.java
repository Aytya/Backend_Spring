package com.example.project.controller;

import com.example.project.auth.AuthenticationResponse;
import com.example.project.auth.RegistrationRequest;
import com.example.project.auth.StudentRequest;
import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.User;
import com.example.project.service.AuthenticationService;
import com.example.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@CrossOrigin("http://127.0.0.1:4200")
@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private AuthenticationService authenticationService;
    @GetMapping("/students/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<User> getStudentById(@PathVariable Integer id) {
        try {
            System.out.println("AdminController");
            User student = studentService.getStudentById(id);
            System.out.println(student);
            System.out.println("AdminController 2");
            return ResponseEntity.ok(student);
        } catch (ResourceDoesNotExistException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Integer id, Model model) throws ResourceDoesNotExistException {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/student/new")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<AuthenticationResponse> insertStudent(@RequestBody StudentRequest student) {
//        try {
//            User insertedStudent = authenticationService.registrationStudent(student);
//            return ResponseEntity.status(HttpStatus.CREATED).body(insertedStudent);
//        } catch (ResourceAlreadyExistsException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(null);
//        }
        return ResponseEntity.ok(authenticationService.registrationStudent(student));
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Integer id,
                                @ModelAttribute("student") User student,
                                Model model) throws ResourceDoesNotExistException {

        // get student from database by id
        User existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping(value = "student/all")
    public ResponseEntity<List<User>> getStudent() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }
    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    public String put() {
        return "PUT:: admin controller";
    }

    @DeleteMapping(value = "student/{id}")
//    @PreAuthorize("hasAuthority('admin:delete')")
    public void delete(@PathVariable Integer id) throws ResourceDoesNotExistException {
        studentService.deleteStudentById(id);
    }
    @GetMapping("/status")
    public String status() {
        return "Working!";
    }
}
