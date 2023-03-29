package com.aspiresys.CRUD.OPERATIONS.service;

import com.aspiresys.CRUD.OPERATIONS.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee,long id);
    void deleteEmployee(long id);
}
