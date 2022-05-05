package com.company.Topology.APIs;

import com.company.Topology.APIs.Parser.TopologyParserApi;
import com.company.Topology.APIs.Utilities.TopologyApiUtilities;
import com.company.Topology.Topology;

import java.util.ArrayList;

// Singleton class where only one instance is created during running time
public class TopologyApi {
    ArrayList<Topology>topologies;

    private static TopologyApi topologyApi=new TopologyApi();

    private TopologyApi(){}

    public static TopologyApi createTopologyApi(){
        return topologyApi;
    }

    public ArrayList<Topology> getTopologies() {
        return topologies;
    }

    public void setTopologies(ArrayList<Topology> topologies) {
        this.topologies = topologies;
    }

    public void addTopology(Topology topology){
        this.topologies.add(topology);
    }

    public TopologyParserApi parser(){
        return new TopologyParserApi();
    }

    public TopologyApiUtilities utilities(){
        return new TopologyApiUtilities();
    }


}
