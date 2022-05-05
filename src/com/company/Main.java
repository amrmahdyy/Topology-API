package com.company;


import com.company.Topology.APIs.TopologyApi;
import com.company.Topology.Topology;

public class Main {
   public static String defaultPath="/Users/test/Desktop/Web development projects/Master Micro assignment/JsonDemo/src/com/company/topology.json";

    public static void main(String[] args) {
        TopologyApi topologyApi=TopologyApi.createTopologyApi();
       topologyApi.topologyApiUtilities.readJson(defaultPath);
       topologyApi.topologyApiUtilities.currentTopologies();
       Topology topology=topologyApi.topologyApiUtilities.getTopology("top1");
        System.out.println(topologyApi.topologyApiUtilities.deleteTopology("top1"));
      // topologyApi.topologyApiUtilities.printAllDevicesOfTopology(topology.getComponents());
      // topologyApi.utilities().printAllDevicesOfTopology(topology.getComponents());
    }
}
