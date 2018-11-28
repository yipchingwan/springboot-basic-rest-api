package com.tw.apistackbase.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Comany {
    private String companyName;
    private int employeesNumber;
    private List<Employee> employeeList;
    private int idIndex = -1;


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getEmployeesNumber() {
        this.employeesNumber = this.employeeList.size();
        return employeesNumber;
    }


    public void setIdIndex(int idIndex) {
        this.idIndex = idIndex;
    }

    public Comany(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public Comany(){
        this.employeeList = new ArrayList<Employee>();
    }

    public List<Employee> getEmployeeList(){
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

    public Employee getEmployeeById(int userId){
        for (Employee employee1:employeeList) {
            if(employee1.getId()==userId){
                return employee1;
            }
        }
        return null;
    }

    public List<Employee> getEmployeeByPage(int page, int pageSize){
        int start = page*pageSize-pageSize;
        List<Employee> employeesInPage = new ArrayList<Employee>();
        for (int i =start; i<start+pageSize; i++){
            if(i==this.employeeList.size()-1){
                employeesInPage.add(this.employeeList.get(i));
                break;
            }
            employeesInPage.add(this.employeeList.get(i));
        }
        return employeesInPage;
    }

    public List<Employee> getEmployeeByGender(String gender){
        List<Employee> employeesWithGender = new ArrayList<Employee>();
        for(Employee employee : employeeList){
            if(employee.getGender().equals(gender)){
                employeesWithGender.add(employee);
            }
        }
        return employeesWithGender;
    }



}
