package com.company;


import com.company.Topology.APIs.TopologyApi;
import com.company.Topology.Components.Component;
import com.company.Topology.Components.Resistor;
import com.company.Topology.Topology;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
   public static String defaultPath="/Users/test/Desktop/Web development projects/Master Micro assignment/Topology-API/src/com/company/Topology/Resources/topology.json";

   public static String outputPath="/Users/test/Desktop/Web development projects/Master Micro assignment/Topology-API/src/com/company/Topology/Resources";

   public static void main(String[] args) {


       TopologyApi topologyApi=TopologyApi.createTopologyApi();
//     Reading json file
       topologyApi.topologyApiUtilities.readJson(defaultPath);

//       Current topologies in the memory
       topologyApi.topologyApiUtilities.currentTopologies();

//       Query about which devices are in a given topology.
       Topology topology=topologyApi.topologyApiUtilities.getTopology("top1");
       ArrayList<Component> components=topology.getComponents();
       topologyApi.topologyApiUtilities.printAllDevicesOfTopology(components);

       System.out.println("NetList of res1 component");
//       Query about which devices are connected to a given netlist node in a given topology.
       Component component=topologyApi.topologyApiUtilities.getComponent(components,"res1");
       HashMap<String,String> componentNetList=topologyApi.topologyApiUtilities.getNetList(component);
       topologyApi.topologyApiUtilities.printNetList(componentNetList);

//       Delete a given topology from memory.
       Boolean isDeleted=topologyApi.topologyApiUtilities.deleteTopology("top1");
       System.out.println(isDeleted);


//       Writing a topology on the disk
        topology=new Topology();
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
       topologyApi.topologyApiUtilities.writeJson(topology,outputPath);

    }
}
