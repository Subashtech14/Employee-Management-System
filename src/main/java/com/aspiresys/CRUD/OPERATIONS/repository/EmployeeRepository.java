package com.aspiresys.CRUD.OPERATIONS.repository;

import com.aspiresys.CRUD.OPERATIONS.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
