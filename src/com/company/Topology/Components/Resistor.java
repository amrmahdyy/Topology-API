package com.company.Topology.Components;

import java.util.HashMap;

public class Resistor extends Component{
    private HashMap<String,String>resistance;
    public Resistor(String id, String type, HashMap<String, String> netList) {
        super(id, type, netList);
    }
    public HashMap<String, String> getResistance() {
        return resistance;
    }
    public void setResistance(HashMap<String, String> resistance) {
        this.resistance = resistance;
    }


}
