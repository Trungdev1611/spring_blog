package com.example.Blog_model.employee.service;

import com.example.Blog_model.employee.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO, Long idStore);


    List<EmployeeDTO> getListEmployee(Long idStore);

    EmployeeDTO getEmployeeWithId(Long idEmployee, Long idStore);

    EmployeeDTO upDateEmployee(Long idEmployee, EmployeeDTO employeeDTO, Long idStore);

    void deleteEmployee(Long idEmployee, Long idStore);
}
