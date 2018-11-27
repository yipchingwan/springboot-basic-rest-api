package com.tw.apistackbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employees")
public class EmployeesResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private Employer employer;

    @Autowired
    public EmployeesResource(Employer employer){
        this.employer = employer;
        this.employer.getAll().add(new Employee(0, "Xiaoming", 20,"Male"));
        this.employer.getAll().add(new Employee(1, "Xiaohong", 19,"Female"));
        this.employer.getAll().add(new Employee(2, "Xiaozhi", 15,"Male"));
        this.employer.getAll().add(new Employee(3, "Xiaogang", 16,"Male"));
        this.employer.getAll().add(new Employee(4, "Xiaoxia", 15,"Female"));
    }

    @GetMapping(path="/getAll", produces = {"application/json"})
    public @ResponseBody List<Employee> getAll() {
        return employer.getAll();
    }

    @PostMapping(path="/create", produces = {"application/json"})
    public Employee create(@RequestBody Employee employee) {
        return employer.addEmployee(employee);
    }

    @PutMapping(path="/update/{userID}", produces = {"application/json"})
    public Employee update(@PathVariable int userID, @RequestBody Employee employee){
        return employer.updateEmployee(userID, employee);
    }

    @DeleteMapping(path="/delete/{userID}", produces = {"application/json"})
    public Employee delete(@PathVariable int userID){
        return employer.deleteEmployee(userID);
    }


}
