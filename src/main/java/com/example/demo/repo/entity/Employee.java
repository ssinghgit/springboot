
package com.example.demo.repo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Employee {

    @Id
    long Id;
    private String name;
    private String department;




}
