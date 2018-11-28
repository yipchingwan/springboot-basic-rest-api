package com.tw.apistackbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employees")
public class EmployeesResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private Comany comany;

    @Autowired
    public EmployeesResource(Comany comany){
        this.comany = comany;
        this.comany.setCompanyName("alibaba");
        this.comany.getEmployeeList().add(new Employee(0, "Xiaoming", 20,"Male", 1));
        this.comany.getEmployeeList().add(new Employee(1, "Xiaohong", 19,"Female", 2));
        this.comany.getEmployeeList().add(new Employee(2, "Xiaozhi", 15,"Male",3));
        this.comany.getEmployeeList().add(new Employee(3, "Xiaogang", 16,"Male",4));
        this.comany.getEmployeeList().add(new Employee(4, "Xiaoxia", 15,"Female",5));
    }

    @GetMapping(produces = {"application/json"})
    public @ResponseBody List<Employee> getAll() {
        return comany.getEmployeeList();
    }

    @PostMapping(produces = {"application/json"})
    public Employee create(@RequestBody Employee employee) {
        return comany.addEmployee(employee);
    }

    @PutMapping(path="/{userID}", produces = {"application/json"})
    public Employee update(@PathVariable int userID, @RequestBody Employee employee){
        return comany.updateEmployee(userID, employee);
    }

    @DeleteMapping(path="/{userID}", produces = {"application/json"})
    public Employee delete(@PathVariable int userID){
        return comany.deleteEmployee(userID);
    }

    @GetMapping(path="/{userID}", produces = {"application/json"})
    public Employee getEmplyee(@PathVariable int userID){
        return comany.getEmployeeById(userID);
    }

    @RequestMapping(produces = {"application/json"}, params = {"page", "pageSize"})
    public List<Employee> getPageAndPageSize(@RequestParam(value="page") int page, @RequestParam(value="pageSize") int pageSize){
        return comany.getEmployeeByPage(page, pageSize);
    }
    @RequestMapping(produces = {"application/json"}, params = {"gender"})
    public List<Employee> getEmpByGender(@RequestParam(value="gender") String gender){
        return comany.getEmployeeByGender(gender);
    }


}
