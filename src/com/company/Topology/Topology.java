package com.company.Topology;

import com.company.Topology.Components.Component;

import java.lang.reflect.Array;
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
        if(components==null)
            return null;
        return components;
    }
//    override equals operator two compare two topologies if they have the same values
    @Override
    public boolean equals(Object obj){
        if(obj.getClass()!=this.getClass())
            return false;
        Topology otherTopology=(Topology)obj;
        if(!this.getId().equals(otherTopology.getId()))
            return false;
        if(this.getComponents().size()!=((Topology) obj).getComponents().size())
            return false;
//        Compare components
        ArrayList<Component>componentsTopology=this.getComponents();
        ArrayList<Component>otherComponentsTopology=((Topology) obj).getComponents();
        for(int i=0;i<componentsTopology.size();i++){
            if(!componentsTopology.get(i).equals(otherComponentsTopology.get(i)))
                return false;
        }
        return true;
    }
    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }
    // adding separate component to the topology
    public void addComponent(Component component){
        this.components.add(component);
    }
}
