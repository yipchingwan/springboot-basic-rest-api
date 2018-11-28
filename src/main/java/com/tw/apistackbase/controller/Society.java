package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

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
