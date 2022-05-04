package com.company.Topology.Components;

import java.util.HashMap;

public class Resistor extends Component{
    private HashMap<String,Double>resistance;
    public Resistor(String id, String type, HashMap<String, String> netList) {
        super(id, type, netList);
    }
    public HashMap<String, Double> getResistance() {
        return resistance;
    }
    public void setResistance(HashMap<String, Double> resistance) {
        this.resistance = resistance;
    }


}
