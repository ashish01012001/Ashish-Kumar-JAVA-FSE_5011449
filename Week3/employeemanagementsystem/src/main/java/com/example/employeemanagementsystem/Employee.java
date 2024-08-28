package com.example.employeemanagementsystem;

import javax.persistence.*;
import lombok.Data;
import java.util.List;

// @Entity
// @Table(name = "employees")
// @Data
// public class Employee {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "name", nullable = false)
//     private String name;

//     @Column(name = "email", nullable = false, unique = true)
//     private String email;

//     @ManyToOne
//     @JoinColumn(name = "department_id", nullable = false)
//     private Department department;
// }

// Named Queries for the Employee entity------

@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
        @NamedQuery(name = "Employee.findByDepartmentName", query = "SELECT e FROM Employee e WHERE e.department.name = :departmentName")
})
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}