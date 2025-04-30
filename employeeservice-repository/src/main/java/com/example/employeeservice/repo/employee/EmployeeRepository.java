package com.example.employeeservice.repo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.example.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, RevisionRepository<Employee,Integer,Integer>{

}
