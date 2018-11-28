package com.tw.apistackbase.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Society {
    private List<Comany> comanyList;

    public Society() {
        this.comanyList = new ArrayList<Comany>();
    }

    public List<Comany> getComanyList() {
        return comanyList;
    }

    public Comany addCompany(Comany comany){
        this.comanyList.add(comany);
        return comany;
    }

    public Comany findCompnyByName(String name){
        for (Comany comany:comanyList) {
            if(comany.getCompanyName().equals(name)){
                return comany;
            }
        }
        return null;
    }

    public List<Employee> getEmployeeByCompanyName(String name){
        for (Comany comany:comanyList) {
            if(comany.getCompanyName().equals(name)){
                return comany.getEmployeeList();
            }
        }
        return null;
    }

    public List<Comany> getCompanyByPage(int page, int pageSize){
        int start = page*pageSize-pageSize;
        List<Comany> companiesInPage = new ArrayList<Comany>();
        for (int i =start; i<start+pageSize; i++){
            if(i==this.comanyList.size()-1){
                companiesInPage.add(this.comanyList.get(i));
                break;
            }
            companiesInPage.add(this.comanyList.get(i));
        }
        return companiesInPage;
    }



}
