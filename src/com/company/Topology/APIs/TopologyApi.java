package com.company.Topology.APIs;

import com.company.Topology.APIs.Utilities.TopologyApiUtilities;
import com.company.Topology.Topology;

import java.util.ArrayList;

// Singleton class where only one instance is created during running time
public class TopologyApi {
    public TopologyApiUtilities topologyApiUtilities=new TopologyApiUtilities();

    private static final TopologyApi topologyApi=new TopologyApi();

    private TopologyApi(){}

    public static TopologyApi createTopologyApi(){
        return topologyApi;
    }


}
