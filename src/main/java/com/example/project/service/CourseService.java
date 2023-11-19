package com.example.project.service;

import com.example.project.exception.ResourceAlreadyExistsException;
import com.example.project.exception.ResourceDoesNotExistException;
import com.example.project.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course saveCourse(Course course) throws ResourceAlreadyExistsException;

    Course getCourseById(Integer id) throws ResourceDoesNotExistException;

    Course updateCourse(Integer code, Course course) throws ResourceDoesNotExistException;

    boolean deleteCourseById(Integer id) throws ResourceDoesNotExistException;
}
