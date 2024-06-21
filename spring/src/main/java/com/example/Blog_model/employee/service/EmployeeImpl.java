package com.example.Blog_model.employee.service;

import com.example.Blog_model.exception.NotFoundEx;
import com.example.Blog_model.mapper.EmployeeMapper;
import com.example.Blog_model.employee.dto.EmployeeDTO;
import com.example.Blog_model.employee.entity.Employee;
import com.example.Blog_model.employee.respository.EmployeeRepository;

import com.example.Blog_model.store.entity.Store;
import com.example.Blog_model.store.respository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeImpl implements EmployeeService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE.INSTANCE;
    public  Store checkStoreExit(Long idStore) {
        return storeRepository.findById(idStore).orElseThrow(() -> new NotFoundEx("Not found store"));
    }
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO, Long idStore) {
        Store store =  checkStoreExit(idStore);
        Employee newEmployee = employeeMapper.employeeDtoToEmployee(employeeDTO);
        newEmployee.setStore(store);
        employeeRepository.save(newEmployee);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getListEmployee(Long idStore) {
        checkStoreExit(idStore);

        return employeeRepository.findAll().stream()
                .map(employeeMapper::employeeToEmployeeDTO
                      )
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeWithId(Long idEmployee, Long idStore) {
        checkStoreExit(idStore);
        Optional<Employee> employeeDataOpt = employeeRepository.findById(idEmployee);
        Employee employee = employeeDataOpt.orElseThrow(() -> new NotFoundEx("Not Found data correspond to get detail Store"));

        return employeeMapper.employeeToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO upDateEmployee(Long idEmployee, EmployeeDTO employeeDTO, Long idStore) {

       checkStoreExit(idStore);
        Optional<Employee> employeeDataOpt = employeeRepository.findById(idEmployee);
        Employee employee = employeeDataOpt.orElseThrow(() -> new NotFoundEx("Not Found data correspond to update Store"));

        employeeMapper.updateEmployeeFromDTO( employeeDTO, employee);

        employeeRepository.save(employee);
        return employeeDTO;
    }

    @Override
    public void deleteEmployee(Long idEmployee,Long idStore) {
          checkStoreExit(idStore);
        Optional<Employee> employeeDataOpt = employeeRepository.findById(idEmployee);
        Employee employee = employeeDataOpt.orElseThrow(() -> new NotFoundEx("Not Found data correspond to delete Store"));
        employeeRepository.deleteById(employee.getId());
    }
}
