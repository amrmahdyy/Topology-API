package com.company.Topology.Components;

import java.util.HashMap;

public class Component {
    private final String id;

    private final String type;
    private HashMap<String,String>netList;
    public Component(String id,String type,HashMap<String,String>netList){
        this.id=id;
        this.type=type;
        this.netList=netList;
    }
    @Override
    public boolean equals(Object obj){
        if(obj.getClass()!=this.getClass())
            return false;
        if(!this.netList.equals(((Component) obj).getNetList()))
            return false;
        if(!this.type.equals(((Component) obj).getType()))
            return false;
        return this.id.equals(((Component) obj).getId());
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
