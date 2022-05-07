package com.company.Topology.Tests;

import com.company.Topology.APIs.TopologyApi;
import com.company.Topology.Components.Component;
import com.company.Topology.Components.Nmos;
import com.company.Topology.Components.Resistor;
import com.company.Topology.Topology;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TopologyApiUtilitiesTest {
    static Topology expectedTopology;
     static String inputPath="/Users/test/Desktop/Web development projects/Master Micro assignment/Topology-API/src/com/company/Topology/Resources/topology.json";
    @BeforeAll
    static void setUp(){
         expectedTopology=new Topology();
        // setting topology id
        expectedTopology.setId("top1");

//        Creating netList for resistor component
        HashMap<String,String>resistorNetList=new HashMap<>();
        resistorNetList.put("t1","vdd");
        resistorNetList.put("t2","n1");

//      adding Resistor device component
        Resistor resistor=new Resistor("res1","resistor",resistorNetList);
//      creating  resistance which represents meta data to the resistor
        HashMap<String,String> resistance =new HashMap<>();
        resistance.put("default","100");
        resistance.put("min","10");
        resistance.put("max","1000");
        resistor.setResistance(resistance);
//        adding component to topology component list
        expectedTopology.addComponent(resistor);

//        creating netList for Nmos device component
        HashMap<String,String>nmosNetList=new HashMap<>();
        nmosNetList.put("drain","n1");
        nmosNetList.put("gate","vin");
        nmosNetList.put("source","vss");
//      adding Nmos device component
        Nmos nmos=new Nmos("m1","nmos",nmosNetList);
        HashMap<String,String>m1=new HashMap<>();
        m1.put("default","1.5");
        m1.put("min","1");
        m1.put("max","2");
//        Adding numerical data to Nmos component
        nmos.setM1(m1);
//        Adding component to topology
        expectedTopology.addComponent(nmos);
    }
    @Test
    @Order(1)
    void readJson(){
        Topology topology=TopologyApi.createTopologyApi().topologyApiUtilities.readJson(inputPath).get(0);
        Assertions.assertEquals(expectedTopology,topology);
    }

//    reading all topologies from .json file and test if the number of topologies loaded into memory is correct or not
    @Test
    @Order(2)
    void getTopologies(){
        Assertions.assertEquals(1,TopologyApi.createTopologyApi().topologyApiUtilities.getTopologies().size());
    }

    @ Test
    @Order(3)
    void getNetList(){
        TopologyApi topologyApi=TopologyApi.createTopologyApi();
        System.out.println(topologyApi.topologyApiUtilities.getTopologies().size());

//        Select Topology
        Topology topology=topologyApi.topologyApiUtilities.getTopology("top1");

        ArrayList<Component> components=topologyApi.topologyApiUtilities.getAllDevicesOfTopology(topology);
        System.out.println(components.size());
        Component component=topologyApi.topologyApiUtilities.getComponent(components,"res1");

//      Creating exceptedNetList for resistor component
        HashMap<String,String>exceptedResistorNetList=new HashMap<>();
        exceptedResistorNetList.put("t1","vdd");
        exceptedResistorNetList.put("t2","n1");
        Assertions.assertEquals(component.getNetList(),exceptedResistorNetList);
    }
    @Test
    @Order(5)
    void deleteTopology(){
//        Deleting existing topology
        Assertions.assertEquals(true,TopologyApi.createTopologyApi().topologyApiUtilities.deleteTopology("top1"));
//        deleting a deleted topology
        Assertions.assertFalse(TopologyApi.createTopologyApi().topologyApiUtilities.deleteTopology("top1"));
//        Deleting Unexisting topology
        Assertions.assertFalse(TopologyApi.createTopologyApi().topologyApiUtilities.deleteTopology("existing ID"));
    }

    @Test
    @Order(4)
    void getTopology(){
        TopologyApi topologyApi=TopologyApi.createTopologyApi();
//        checking if a topology with top1 Id exists in The topology that is stored in memory
        Assertions.assertNotNull(topologyApi.topologyApiUtilities.getTopology("top1"));

//      checking if a topology with invalid Id exists in The topology that is stored in memory
        Assertions.assertNull(topologyApi.topologyApiUtilities.getTopology("top3"));
    }

}