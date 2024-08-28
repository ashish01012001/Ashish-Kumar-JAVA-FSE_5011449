package com.example.employeemanagementsystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeDetailsProjection {

    String getName();

    String getEmail();

    @Value("#{target.name + ' (' + target.email + ')'}")
    String getNameWithEmail();
}
