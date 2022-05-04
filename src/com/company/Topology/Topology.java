package com.company.Topology;

import com.company.Topology.Components.Component;

import java.util.ArrayList;

public class Topology {
    private String id;
    ArrayList<Component>components=new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }
    // adding separate component to the topology
    public void addComponent(Component component){
        this.components.add(component);
    }
}
