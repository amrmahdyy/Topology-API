package com.company.Topology.Components;

import java.util.HashMap;

public class Nmos extends Component {
    private HashMap<String,Double>m1;
    public Nmos(String id,String type,HashMap<String,String>netList){
        super(id,type,netList);
    }

    public HashMap<String, Double> getM1() {
        return m1;
    }

    public void setM1(HashMap<String, Double> m1) {
        this.m1 = m1;
    }
}
