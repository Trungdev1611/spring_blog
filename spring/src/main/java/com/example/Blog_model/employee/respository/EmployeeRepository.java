package com.example.Blog_model.employee.respository;

import com.example.Blog_model.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
