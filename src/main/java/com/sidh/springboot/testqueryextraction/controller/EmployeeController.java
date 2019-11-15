package com.sidh.springboot.testqueryextraction.controller;

import com.sidh.springboot.testqueryextraction.model.Employee;
import com.sidh.springboot.testqueryextraction.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepo repo;

    @GetMapping("/get")
    public List<Employee> everyEmployee() {
        List<Employee> employees = new ArrayList<>();
        repo.findAll().forEach(employees::add);
        return employees;
    }

    @GetMapping("/get/{id}")
    public Employee employeeWithId(@PathVariable int id) {
        Optional<Employee> byId = repo.findById(id);
        if(byId.isPresent()) {
            return byId.get();
        }
        else {
            Employee employee = new Employee();
            employee.setFirst_name("employee not found !");
            return employee;
        }
    }
}
