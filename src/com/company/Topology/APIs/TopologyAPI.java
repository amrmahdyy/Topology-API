package com.company.Topology.APIs;

import com.company.Topology.Components.Component;
import com.company.Topology.Topology;

import java.util.ArrayList;
import java.util.HashMap;

public interface TopologyAPI {
    void currentTopologies(ArrayList<Topology>topologies);

    Topology getTopology(ArrayList<Topology>topologies,String id);

    boolean deleteTopology(ArrayList<Topology> topologies,String id);

    ArrayList<Component> getAllDevicesOfTopology(Topology topology);

    void printAllDevicesOfTopology(ArrayList<Component>components);

    Component getComponent(ArrayList<Component>components,String id);

    HashMap<String,String>getNetList(Component component);

    void printNetList(HashMap<String,String>netList);

}
