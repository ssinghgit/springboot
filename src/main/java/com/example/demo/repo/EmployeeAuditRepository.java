package com.example.demo.repo;

import com.example.demo.repo.entity.Employee;
import com.example.demo.repo.entity.EmployeeAudit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAuditRepository extends CrudRepository<EmployeeAudit,Long> {

}
