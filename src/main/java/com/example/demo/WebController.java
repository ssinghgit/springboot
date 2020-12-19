package com.example.demo;

import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    EmployeeRepository employeeRepository;
    @RequestMapping("/hello")
    public Iterable<Employee> saySomething(){
        System.out.println("Calling Something hello");
        Iterable<Employee> listEmpl = employeeRepository.findAll();

        Employee emp = new Employee();
        emp.setDepartment("");

        return listEmpl;
    }
}
