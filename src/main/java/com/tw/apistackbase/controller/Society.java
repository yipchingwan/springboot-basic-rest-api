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
}
