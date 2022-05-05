package com.company.Topology.APIs.Utilities;

import com.company.Topology.Components.Component;
import com.company.Topology.Topology;

import java.util.ArrayList;
import java.util.HashMap;

public interface TopologyUtilities {
    Boolean readJson(String path);

    Boolean writeJson(Topology topology,String path);

    void currentTopologies();

    Topology getTopology(String id);

    boolean deleteTopology(String id);

    ArrayList<Component> getAllDevicesOfTopology(Topology topology);

    void printAllDevicesOfTopology(ArrayList<Component>components);

    Component getComponent(ArrayList<Component>components,String id);

    HashMap<String,String>getNetList(Component component);

    void printNetList(HashMap<String,String>netList);

}
