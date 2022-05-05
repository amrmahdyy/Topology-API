package com.company.Topology.Components;

import java.util.HashMap;

public class Component {
    private String id;

    private String type;
    private HashMap<String,String>netList;
    public Component(String id,String type,HashMap<String,String>netList){
        this.id=id;
        this.type=type;
        this.netList=netList;
    }
    public String getId() {
        return id;
    }


    public String getType() {
        return type;
    }

    public HashMap<String, String> getNetList() {
        return netList;
    }

    public void setNetList(HashMap<String, String> netList) {
        this.netList = netList;
    }

}
