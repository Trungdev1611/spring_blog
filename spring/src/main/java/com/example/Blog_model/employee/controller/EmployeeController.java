package com.example.Blog_model.employee.controller;


import com.example.Blog_model.employee.dto.EmployeeDTO;
import com.example.Blog_model.employee.service.EmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private final EmployeeImpl employeeImpl;

    public EmployeeController(EmployeeImpl employeeImpl) {
        this.employeeImpl = employeeImpl;
    }

    @PostMapping("/store/{idStore}/employee/create")
    ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long idStore) {

        EmployeeDTO response =  employeeImpl.createEmployee(employeeDTO,  idStore);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/store/{idStore}/employee")
    ResponseEntity<List<EmployeeDTO>> getListEmployee( @PathVariable Long idStore) {

        List<EmployeeDTO> response =  employeeImpl.getListEmployee(idStore);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/store/{idStore}/employee/{idEmployee}")
    ResponseEntity<EmployeeDTO> getListEmployee(@PathVariable Long idEmployee,  @PathVariable Long idStore) {

        EmployeeDTO response =  employeeImpl.getEmployeeWithId(idEmployee, idStore);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/store/{idStore}/employee/{idEmployee}")
    ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long idEmployee, @RequestBody EmployeeDTO employeeDTO, @PathVariable Long idStore) {

        EmployeeDTO response =  employeeImpl.upDateEmployee(idEmployee, employeeDTO, idStore);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/store/{idStore}/employee/{idEmployee}")
    ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable Long idEmployee, @PathVariable Long idStore) {
        employeeImpl.deleteEmployee(idEmployee, idStore);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}