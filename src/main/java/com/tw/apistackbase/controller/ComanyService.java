package com.tw.apistackbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/companies")
public class ComanyService {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private Society society;

    @Autowired
    public ComanyService(Society society){

        Comany comanyA = new Comany();
        comanyA.setCompanyName("alibaba");
        comanyA.getEmployeeList().add(new Employee(0, "Xiaoming", 20,"Male", 1));
        comanyA.getEmployeeList().add(new Employee(1, "Xiaohong", 19,"Female", 2));
        comanyA.getEmployeeList().add(new Employee(2, "Xiaozhi", 15,"Male",3));
        comanyA.getEmployeeList().add(new Employee(3, "Xiaogang", 16,"Male",4));
        comanyA.getEmployeeList().add(new Employee(4, "Xiaoxia", 15,"Female",5));

        Comany comanyB = new Comany();
        comanyB.setCompanyName("Another");
        comanyB.getEmployeeList().add(new Employee(0, "XiaomingN", 20,"Male", 1));
        comanyB.getEmployeeList().add(new Employee(1, "XiaohongN", 19,"Female", 2));
        comanyB.getEmployeeList().add(new Employee(2, "XiaozhiN", 15,"Male",3));
        comanyB.getEmployeeList().add(new Employee(3, "XiaogangN", 16,"Male",4));
        comanyB.getEmployeeList().add(new Employee(4, "XiaoxiaN", 15,"Female",5));
        this.society = society;
        society.addCompany(comanyA);
        society.addCompany(comanyB);

    }

    @GetMapping(produces = {"application/json"})
    public List<Comany> getAll() {
        return society.getComanyList();
    }

    @GetMapping(path="/{companyName}", produces = {"application/json"})
    public Comany getComanyByName(@PathVariable String companyName) {
        return society.findCompnyByName(companyName);
    }
    @GetMapping(path="/{companyName}/employee", produces = {"application/json"})
    public List<Employee> getEmployeeByCompanyName(@PathVariable String companyName) {
        return society.getEmployeeByCompanyName(companyName);
    }

    @RequestMapping(produces = {"application/json"}, params = {"page", "pageSize"})
    public List<Comany> getPageAndPageSize(@RequestParam(value="page") int page, @RequestParam(value="pageSize") int pageSize){
        return society.getCompanyByPage(page, pageSize);
    }




}
