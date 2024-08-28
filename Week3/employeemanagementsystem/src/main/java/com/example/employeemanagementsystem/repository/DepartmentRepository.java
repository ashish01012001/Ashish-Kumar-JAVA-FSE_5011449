package com.example.employeemanagementsystem.repository;

import com.example.EmployeeManagementSystem.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query method to find departments by name
    List<Department> findByName(String name);
}
