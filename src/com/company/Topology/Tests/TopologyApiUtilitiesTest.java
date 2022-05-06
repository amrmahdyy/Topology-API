package com.company.Topology.Tests;

import com.company.Topology.APIs.TopologyApi;
import com.company.Topology.APIs.Utilities.TopologyApiUtilities;
import com.company.Topology.Components.Nmos;
import com.company.Topology.Components.Resistor;
import com.company.Topology.Topology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

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
//    @Test
//    void readJson(){
//        Topology topology=TopologyApi.createTopologyApi().topologyApiUtilities.readJson(inputPath).get(0);
//        Assertions.assertEquals(expectedTopology,topology);
//    }

//    reading all topologies from .json file and test if the number of topologies loaded into memory is correct or not
    @Test
    void getTopologies(){
        ArrayList<Topology> topologies=TopologyApi.createTopologyApi().topologyApiUtilities.readJson(inputPath);
        Assertions.assertEquals(1,topologies.size());
    }
    @Test
    void deleteTopology(){
        TopologyApi topologyApi=TopologyApi.createTopologyApi();
        Topology topology=topologyApi.topologyApiUtilities.readJson(inputPath).get(0);
//        Deleting existing topology
        Assertions.assertEquals(true,topologyApi.topologyApiUtilities.deleteTopology("top1"));
//        deleting a deleted topology
        Assertions.assertFalse(topologyApi.topologyApiUtilities.deleteTopology("top1"));
//        Deleting Unexisting topology
        Assertions.assertFalse(topologyApi.topologyApiUtilities.deleteTopology("existing ID"));
    }

    @Test
    void getTopology(){
        TopologyApi topologyApi=TopologyApi.createTopologyApi();
        Topology topology=topologyApi.topologyApiUtilities.readJson(inputPath).get(0);
//        checking if a topology with top1 Id exists in The topology that is stored in memory
        Assertions.assertNotNull(topologyApi.topologyApiUtilities.getTopology("top1"));

//      checking if a topology with invalid Id exists in The topology that is stored in memory
        Assertions.assertNull(topologyApi.topologyApiUtilities.getTopology("top3"));
    }
}