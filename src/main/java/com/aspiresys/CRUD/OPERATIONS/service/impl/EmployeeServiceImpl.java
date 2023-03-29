package com.aspiresys.CRUD.OPERATIONS.service.impl;

import com.aspiresys.CRUD.OPERATIONS.exception.ResourceNotFoundException;
import com.aspiresys.CRUD.OPERATIONS.model.Employee;
import com.aspiresys.CRUD.OPERATIONS.repository.EmployeeRepository;
import com.aspiresys.CRUD.OPERATIONS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
//        Optional<Employee> employee= employeeRepository.findById(id);
//        if (employee.isPresent()) return employee.get();
//        else throw new ResourceNotFoundException("Employee","Id",id);
        return employeeRepository.findById(id).orElseThrow(()-> {throw new ResourceNotFoundException("Employee","Id",id);});


    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
            //We need to check weather employee with given id is existed in DB or not
        Employee existngEmployee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
        existngEmployee.setFirstName(employee.getFirstName());
        existngEmployee.setLastName(employee.getLastName());
        existngEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existngEmployee);
        return existngEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //check wheather the employee exist in a DB or Not
        employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }
}
