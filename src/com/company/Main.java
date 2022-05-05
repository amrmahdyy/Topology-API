package com.company;

import com.company.Topology.APIs.API;
import com.company.Topology.APIs.JsonParser;
import com.company.Topology.Components.Component;
import com.company.Topology.Topology;

import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
   public static String defaultPath="/Users/test/Desktop/Web development projects/Master Micro assignment/JsonDemo/src/com/company/topology.json";

    public static void main(String[] args) {
	// write your code here
        JsonParser jsonParser=new JsonParser();
        jsonParser.readJson(defaultPath);
       ArrayList<Topology>topologies=jsonParser.getTopologies();
        API api=new API();
        api.currentTopologies(topologies);
        System.out.println(api.deleteTopology(topologies,"top"));
        Topology topology=api.getTopology(topologies,"top");
        ArrayList<Component> components=api.getAllDevicesOfTopology(topology);
        api.printAllDevicesOfTopology(components);
        Component component=api.getComponent(components,"ms");
        api.printNetList(api.getNetList(component));
    }
}
