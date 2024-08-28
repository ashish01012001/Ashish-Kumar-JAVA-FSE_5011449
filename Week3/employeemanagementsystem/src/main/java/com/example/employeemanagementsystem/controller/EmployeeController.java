package com.example.employeemanagementsystem.controller;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

// @RestController
// @RequestMapping("/api/employees")
// public class EmployeeController {

// private final EmployeeRepository employeeRepository;

// public EmployeeController(EmployeeRepository employeeRepository) {
// this.employeeRepository = employeeRepository;
// }

// // Create a new employee
// @PostMapping
// public Employee createEmployee(@RequestBody Employee employee) {
// return employeeRepository.save(employee);
// }

// // Get all employees
// @GetMapping
// public List<Employee> getAllEmployees() {
// return employeeRepository.findAll();
// }

// // Get employee by ID
// @GetMapping("/{id}")
// public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
// Optional<Employee> employee = employeeRepository.findById(id);
// return employee.map(ResponseEntity::ok).orElseGet(() ->
// ResponseEntity.notFound().build());
// }

// // Update an employee
// @PutMapping("/{id}")
// public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
// @RequestBody Employee employeeDetails) {
// Optional<Employee> employee = employeeRepository.findById(id);
// if (employee.isPresent()) {
// Employee updatedEmployee = employee.get();
// updatedEmployee.setName(employeeDetails.getName());
// updatedEmployee.setEmail(employeeDetails.getEmail());
// updatedEmployee.setDepartment(employeeDetails.getDepartment());
// return ResponseEntity.ok(employeeRepository.save(updatedEmployee));
// } else {
// return ResponseEntity.notFound().build();
// }
// }

// // Delete an employee
// @DeleteMapping("/{id}")
// public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
// if (employeeRepository.existsById(id)) {
// employeeRepository.deleteById(id);
// return ResponseEntity.noContent().build();
// } else {
// return ResponseEntity.notFound().build();
// }
// }
// }

// Controller for combining pagination and sorting

// @RestController
// @RequestMapping("/api/employees")
// public class EmployeeController {

//     private final EmployeeRepository employeeRepository;

//     public EmployeeController(EmployeeRepository employeeRepository) {
//         this.employeeRepository = employeeRepository;
//     }

//     // Get a paginated and sorted list of employees
//     @GetMapping
//     public Page<Employee> getAllEmployees(
//             @RequestParam(defaultValue = "0") int page,
//             @RequestParam(defaultValue = "10") int size,
//             @RequestParam(defaultValue = "id") String sortBy,
//             @RequestParam(defaultValue = "asc") String sortDir) {

//         // Determine sort direction
//         Sort.Direction direction = sortDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

//         // Create Pageable object with page number, size, and sort order
//         Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

//         // Return paginated and sorted employees
//         return employeeRepository.findAll(pageable);
//     }

//     // Get a paginated and sorted list of employees by department ID
//     @GetMapping("/department/{departmentId}")
//     public Page<Employee> getEmployeesByDepartmentId(
//             @PathVariable Long departmentId,
//             @RequestParam(defaultValue = "0") int page,
//             @RequestParam(defaultValue = "10") int size,
//             @RequestParam(defaultValue = "id") String sortBy,
//             @RequestParam(defaultValue = "asc") String sortDir) {

//         // Determine sort direction
//         Sort.Direction direction = sortDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

//         // Create Pageable object with page number, size, and sort order
//         Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

//         // Return paginated and sorted employees by department ID

//         return employeeRepository.findByDepartmentId(departmentId, pageable);
//     }
// }

// Controller for testing the projection --------

import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.projection.EmployeeDetailsProjection;
import com.example.EmployeeManagementSystem.projection.EmployeeNameAndEmailProjection;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Endpoint to get employee name and email using interface-based projection
    @GetMapping("/projections/names-emails")
    public List<EmployeeNameAndEmailProjection> getEmployeeNameAndEmail() {
        return employeeRepository.findAllProjectedBy();
    }

    // Endpoint to get employee details using @Value annotation
    @GetMapping("/projections/details")
    public List<EmployeeDetailsProjection> getEmployeeDetails() {
        return employeeRepository.findAllProjectedWithDetailsBy();
    }

    // Endpoint to get employee DTO by department ID using class-based projection
    @GetMapping("/dto/department/{departmentId}")
    public List<EmployeeDTO> getEmployeeDTOByDepartment(Long departmentId) {
        return employeeRepository.findEmployeesByDepartmentId(departmentId);
    }
}
