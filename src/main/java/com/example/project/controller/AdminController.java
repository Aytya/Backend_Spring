package com.example.project.controller;

import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.Student;
import com.example.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        try {
            Student student = studentService.getStudentById(id);
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
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
        try {
            Student insertedStudent = studentService.saveStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertedStudent);
        } catch (ResourceAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Integer id,
                                @ModelAttribute("student") Student student,
                                Model model) throws ResourceDoesNotExistException {

        // get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping(value = "student/all")
    public ResponseEntity<List<Student>> getStudent() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }
    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    public String put() {
        return "PUT:: admin controller";
    }

    @DeleteMapping(value = "student/delete/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void delete(@PathVariable Integer id) throws ResourceDoesNotExistException {
        studentService.deleteStudentById(id);
    }
    @GetMapping("/status")
    public String status() {
        return "Working!";
    }
}
