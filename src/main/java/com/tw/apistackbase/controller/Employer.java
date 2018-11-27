package com.tw.apistackbase.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Employer {
    private List<Employee> employeeList;
    private int idIndex = -1;


    public int getIdIndex() {
        return idIndex;
    }

    public void setIdIndex(int idIndex) {
        this.idIndex = idIndex;
    }

    public Employer(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public Employer(){
        this.employeeList = new ArrayList<Employee>();
    }

    public List<Employee> getAll(){
        return employeeList;
    }

    public Employee addEmployee(Employee employee){
        this.idIndex+=1;
        employee.setId(this.idIndex);
        this.employeeList.add(employee);
        return employee;
    }

    public Employee updateEmployee(int userId, Employee employee){
        int target=0;
        for (Employee employee1:employeeList) {
            if(employee1.getId()==userId){
                target = employeeList.indexOf(employee1);
            }
        }
        this.employeeList.set(target, employee);
        return employee;
    }

    public Employee deleteEmployee(int userId){
        int target=0;
        for (Employee employee1:employeeList) {
            if(employee1.getId()==userId){
                target = employeeList.indexOf(employee1);
            }
        }
        return this.employeeList.remove(target);
    }



}
