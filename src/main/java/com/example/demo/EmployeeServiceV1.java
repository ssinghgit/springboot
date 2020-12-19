package com.example.demo;

import com.example.demo.repo.EmployeeAuditRepository;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.entity.Employee;
import com.example.demo.repo.entity.EmployeeAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service("v1")
public class EmployeeServiceV1  implements  EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeAuditRepository employeeAuditRepository;

    @Override
    public List<Employee> getEmployees(){
        System.out.println("Calling Something hello");
        Iterable<Employee> listEmpl = employeeRepository.findAll();
       return  StreamSupport.stream(listEmpl.spliterator(),false).collect(Collectors.toList());

    }


    @Transactional
    @Override
    @Secured("ROLE_WRITER")
    public Employee addEmployeeWithRef() {
        Employee employee = new Employee();
        employee.setDepartment("IT");
        employee.setName("santosh");
        Employee savedEmployee = employeeRepository.save(employee);
        //Deliberately failing it so that we can test transactional
        int b=0;
        System.out.println(5/b) ;
        EmployeeAudit employeeAudit = new EmployeeAudit();
        employeeAudit.setId(savedEmployee.getId());
        employeeAudit.setDepartment(savedEmployee.getDepartment());
        employeeAudit.setName(savedEmployee.getName());
        employeeAuditRepository.save(employeeAudit);
        return employee;
    }


}
