package com.company.Topology.APIs.Utilities;

import com.company.Topology.Components.Component;
import com.company.Topology.Topology;

import java.util.ArrayList;
import java.util.HashMap;

public class TopologyApiUtilities implements TopologyUtilities   {
    /**
     * Printing current number of topologies and print all topologies' id's
     *
     * @param  topologies ArrayList of Topology
     */
    @Override
    public void currentTopologies(ArrayList<Topology> topologies) {
        System.out.println("Number of Topologies: "+topologies.size());
        for(Topology topology : topologies){
            System.out.println(topology.getId());
        }
    }

    /**
     * Getting specific topology by given id
     *
     * @param  topologies arrayList of topology
     * @param id specified topology id
     * @return    topology on matching id
     * @return null on no match
     */
    @Override
    public Topology getTopology(ArrayList<Topology> topologies, String id) {
        for(Topology topology:topologies){
            if(topology.getId().equals(id)){
                return topology;
            }
        }
        return null;
    }
    /**
     * Deleting a topology with a specific id
     *
     * @param  topologies arrayList of topology
     * @param id specified topology id
     * @return    true on finding a topology with the same id
     * @return false on no match
     */
    @Override
    public boolean deleteTopology(ArrayList<Topology> topologies,String id) {
        for(int i=0;i<topologies.size();i++){
            if(topologies.get(i).getId().equals(id)){
                topologies.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Component> getAllDevicesOfTopology(Topology topology) {
        if(topology==null)
            return null;
        return topology.getComponents();
    }

    @Override
    public void printAllDevicesOfTopology(ArrayList<Component> components) {
        if(components==null)
            return;
        System.out.println("Current Devices:");
        for(Component component:components){
            System.out.println(component.getId());
        }
    }

    @Override
    public Component getComponent(ArrayList<Component> components,String id) {
        if(components==null)
            return null;
        for(Component component:components){
            if(component.getId().equals(id)){
                return component;
            }
        }
        return null;
    }


    @Override
    public HashMap<String, String> getNetList(Component component) {
        if(component==null)
            return null;
        return component.getNetList();
    }

    @Override
    public void printNetList(HashMap<String, String> netList) {
        if(netList==null)
            return;
        int order=1;
        for(String name:netList.keySet()){
            String value=netList.get(name);
            System.out.println(String.valueOf(order++)+")"+" "+name+" : "+value);
        }
    }
}
