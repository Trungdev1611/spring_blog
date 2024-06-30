package com.example.Blog_model.mapper;

import com.example.Blog_model.employee.dto.EmployeeDTO;

import com.example.Blog_model.employee.dto.EmployeeDTO;
import com.example.Blog_model.employee.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper  //@Mapper: Annotation để đánh dấu interface này là một mapper của MapStruct.
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    // update Store from data in storeDTO
    void updateEmployeeFromDTO(EmployeeDTO employeeDTO, @MappingTarget Employee employee);
}
