package com.company;


import com.company.Topology.APIs.TopologyApi;

public class Main {
   public static String defaultPath="/Users/test/Desktop/Web development projects/Master Micro assignment/JsonDemo/src/com/company/topology.json";

    public static void main(String[] args) {
        TopologyApi topologyApi=TopologyApi.createTopologyApi();
        topologyApi.parser().readJson(defaultPath);
	// write your code here
//        JsonParser jsonParser=new JsonParser();
//        jsonParser.readJson(defaultPath);
//       ArrayList<Topology>topologies=jsonParser.getTopologies();
//        TopologyApiUtilities api=new TopologyApiUtilities();
//        api.currentTopologies(topologies);
//        System.out.println(api.deleteTopology(topologies,"top"));
//        Topology topology=api.getTopology(topologies,"top");
//        ArrayList<Component> components=api.getAllDevicesOfTopology(topology);
//        api.printAllDevicesOfTopology(components);
//        Component component=api.getComponent(components,"ms");
//        api.printNetList(api.getNetList(component));
    }
}
