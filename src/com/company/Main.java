package com.company;


import com.company.Topology.APIs.TopologyApi;
import com.company.Topology.Components.Resistor;
import com.company.Topology.Topology;

import java.util.HashMap;

public class Main {
   public static String defaultPath="/Users/test/Desktop/Web development projects/Master Micro assignment/Topology-API/src/com/company/Topology/Resources/topology.json";

   public static String outputPath="/Users/test/Desktop/Web development projects/Master Micro assignment/Topology-API/src/com/company/Topology/Resources";

   public static void main(String[] args) {
        TopologyApi topologyApi=TopologyApi.createTopologyApi();
        Topology topology=new Topology();
        topology.setId("test");

        // netlist
        HashMap<String,String>netList=new HashMap<>();
        netList.put("t1","capacitor");
       netList.put("t2","vss");
       // resistor type
       HashMap<String,String>resistorMap=new HashMap<>();
       resistorMap.put("default","20");
       resistorMap.put("min","1");
       resistorMap.put("max","500");


       Resistor resistor1=new Resistor("5","resistor",netList);
       resistor1.setResistance(resistorMap);
       topology.addComponent(resistor1);

       topologyApi.topologyApiUtilities.readJson(defaultPath);
       topologyApi.topologyApiUtilities.writeJson(topology,outputPath);
       topologyApi.topologyApiUtilities.currentTopologies();
       //Topology topology=topologyApi.topologyApiUtilities.getTopology("top1");
        //System.out.println(topologyApi.topologyApiUtilities.deleteTopology("top1"));
      // topologyApi.topologyApiUtilities.printAllDevicesOfTopology(topology.getComponents());
      // topologyApi.utilities().printAllDevicesOfTopology(topology.getComponents());
    }
}
