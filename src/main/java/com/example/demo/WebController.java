package com.example.demo;

import com.example.demo.repo.EmployeeRepository;
import com.example.demo.repo.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
//@ConditionalOnProperty("commmonServerConfig.jpaEnabled")
@Slf4j
public class WebController {



    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationContext applicationContext;

    @Value("commmonServerConfig.jpaEnabled")
    String myProp;

    @GetMapping(value = "/api/{version}/hello")
    public ResponseEntity<?> saySomething(@PathVariable("version") String version, Authentication authentication){
        Boolean environmentProperty = environment.getProperty("commmonServerConfig.jpaEnabled", Boolean.class);
        log.info("API called by {} ",authentication.getName());
        EmployeeService employeeService = null;
        try {
             employeeService = (EmployeeService) applicationContext.getBean(version);
        } catch (BeansException e) {
            String errorCode= UUID.randomUUID().toString();
            log.error(" error " + errorCode + " occured ", e);

            return ResponseEntity.badRequest().body("Please contact customer support with this error code " + errorCode);
        }
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping("/api/{version}/addemployee")

    public ResponseEntity<?> saveEmployee(@PathVariable("version") String version){
        Boolean environmentProperty = environment.getProperty("commmonServerConfig.jpaEnabled", Boolean.class);
        EmployeeService employeeService = null;
        try {
            employeeService = (EmployeeService) applicationContext.getBean(version);
        } catch (BeansException e) {
            String errorCode= UUID.randomUUID().toString();
            log.error(" error " + errorCode + " occured ", e);

            return ResponseEntity.badRequest().body("Please contact customer support with this error code " + errorCode);
        }
        return ResponseEntity.ok(employeeService.addEmployeeWithRef());
    }
}
