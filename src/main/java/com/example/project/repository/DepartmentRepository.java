package com.example.project.repository;

import com.example.project.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {


    Department findByDepartmentId(String departmentId);

    @Transactional
    void deleteByDepartmentId(String departmentId);

}