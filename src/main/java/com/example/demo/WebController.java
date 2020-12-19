package com.example.demo;

import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ConditionalOnProperty("commmonServerConfig.jpaEnabled")
public class WebController {



    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationContext applicationContext;

    @Value("commmonServerConfig.jpaEnabled")
    String myProp;

    @RequestMapping("/api/{version}/hello")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<List<Employee>> saySomething(@PathVariable("version") String version){
        Boolean environmentProperty = environment.getProperty("commmonServerConfig.jpaEnabled", Boolean.class);
        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class, version);
        if ( employeeService == null ){
           return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employeeService.getEmployees());
    }
}
