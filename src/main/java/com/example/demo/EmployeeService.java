package com.example.demo;

import com.example.demo.repo.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();


    Employee addEmployeeWithRef();
}
