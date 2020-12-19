package com.example.demo;

import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service("v1")
public class EmployeeServiceV1  implements  EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployees(){
        System.out.println("Calling Something hello");
        Iterable<Employee> listEmpl = employeeRepository.findAll();
       return  StreamSupport.stream(listEmpl.spliterator(),false).collect(Collectors.toList());

    }

    @Transactional
    public void addEmployeeWithRef() {


    }


}
