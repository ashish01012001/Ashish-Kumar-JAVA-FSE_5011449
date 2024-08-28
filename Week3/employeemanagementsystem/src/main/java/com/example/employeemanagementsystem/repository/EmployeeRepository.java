package com.example.employeemanagementsystem.repository;

import com.example.EmployeeManagementSystem.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.EmployeeManagementSystem.dto.EmployeeDTO;

import java.util.List;

// public interface EmployeeRepository extends JpaRepository<Employee, Long> {

// // Derived query method to find employees by name
// List<Employee> findByName(String name);

// // Derived query method to find employees by department
// List<Employee> findByDepartmentId(Long departmentId);
// }

// Using custom query methods using @Query ----------

// public interface EmployeeRepository extends JpaRepository<Employee, Long> {

// // Find employees by department name using JPQL
// @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
// List<Employee> findByDepartmentName(@Param("departmentName") String
// departmentName);

// // Find employees whose email ends with a specific domain using native SQL
// @Query(value = "SELECT * FROM employees e WHERE e.email LIKE %:domain",
// nativeQuery = true)
// List<Employee> findByEmailDomain(@Param("domain") String domain);
// }

// Using Named Queries -------
// public interface EmployeeRepository extends JpaRepository<Employee, Long> {

// // Use named query to find employee by email
// List<Employee> findByEmail(String email);

// // Use named query to find employees by department name
// List<Employee> findByDepartmentName(String departmentName);
// }

// Main function for implementing pagination ---------

// public interface EmployeeRepository extends JpaRepository<Employee, Long> {

// // Paginated list of employees
// Page<Employee> findAll(Pageable pageable);

// // Paginated list of employees by department ID
// Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);
// }

// Using Interface-Based Projection --------

// public interface EmployeeRepository extends JpaRepository<Employee, Long> {

// // Fetch only name and email using projection
// List<EmployeeNameAndEmailProjection> findAllProjectedBy();
// }

// Using class-based projection -------
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Use constructor expression for class-based projection
    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeDTO(e.name, e.email) FROM Employee e WHERE e.department.id = :departmentId")
    List<EmployeeDTO> findEmployeesByDepartmentId(@Param("departmentId") Long departmentId);
}