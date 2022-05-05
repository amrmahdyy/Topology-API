package com.company.Topology.APIs.Utilities;

import com.company.Topology.Components.Component;
import com.company.Topology.Components.Nmos;
import com.company.Topology.Components.Resistor;
import com.company.Topology.Topology;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class TopologyApiUtilities implements TopologyUtilities   {
    ArrayList<Topology>topologies=new ArrayList<>();
    /**
     * Creating Topology by reading from disk and loading all topologies on main memory
     *
     * @param  path the json file path
     * @return      true on successfully reading and false on failure
     */
    public  Boolean readJson(String path){
        try {
            String jsonInString=new String(Files.readAllBytes(Paths.get(path)));

            JSONArray jsonArray=new JSONArray(jsonInString);
            // iterating over the json array as the json file might have multiple topologies
            for(int i=0;i<jsonArray.length();i++){
                JSONObject currTopology=jsonArray.getJSONObject(i);
                String topologyId=currTopology.getString("id");
                // Initializing topology object
                Topology topology=new Topology();
                topology.setId(topologyId);
                JSONArray components=currTopology.getJSONArray("components");
                for(int j=0;j<components.length();j++){

                    JSONObject currComponent=components.getJSONObject(j);
                    String componentId=currComponent.getString("id");
                    String type=currComponent.getString("type");
                    HashMap<String,String>netList=new HashMap<>();


//                if type is resistor, initialize resistor object
                    if(type.equals("resistor")) {
                        HashMap<String,String>resistance=new HashMap<>();

                        netList.put("t1",currComponent.getJSONObject("netlist").get("t1").toString());
                        netList.put("t2",currComponent.getJSONObject("netlist").get("t2").toString());

                        resistance.put("default",currComponent.getJSONObject("resistance").get("default").toString());
                        resistance.put("min",currComponent.getJSONObject("resistance").get("min").toString());
                        resistance.put("max",currComponent.getJSONObject("resistance").get("max").toString());

                        Resistor resistor = new Resistor(componentId, type, netList);

                        resistor.setResistance(resistance);

                        topology.addComponent(resistor);
                    }
//                if type is resistor, initialize resistor object
                    else if(type.equals("nmos")){

                        HashMap<String,String>ml=new HashMap<>();

                        netList.put("drain",currComponent.getJSONObject("netlist").get("drain").toString());
                        netList.put("gate",currComponent.getJSONObject("netlist").get("gate").toString());
                        netList.put("source",currComponent.getJSONObject("netlist").get("source").toString());

                        ml.put("default",currComponent.getJSONObject("m(l)").get("default").toString());
                        ml.put("min",currComponent.getJSONObject("m(l)").get("min").toString());
                        ml.put("max",currComponent.getJSONObject("m(l)").get("max").toString());

                        Nmos nmos=new Nmos(componentId,type,netList);

                        nmos.setM1(ml);

                        topology.addComponent(nmos);
                    }
//                if type is not defined in classes, initialize a component object
                    else{
                        Component component=new Component(componentId,type,netList);
                        topology.addComponent(component);
                    }
                }
                topologies.add(topology);
            }

        }
        catch(IOException ioe){
            System.out.println("Error in Reading Json file "+ioe);
            return false;
        }
        return true;
    }
    public ArrayList<Topology>getTopologies(){
        return this.topologies;
    }

    /**
     * Printing current number of topologies and print all topologies' id's
     *
     */
    @Override
    public void currentTopologies() {
        System.out.println("Number of Topologies: "+topologies.size());
        for(Topology topology : topologies){
            System.out.println(topology.getId());
        }
    }

    /**
     * Getting specific topology by given id
     *
     * @param id specified topology id
     * @return    topology on matching id
     * @return null on no match
     */
    @Override
    public Topology getTopology(String id) {
        for(Topology topology:topologies){
            if(topology.getId().equals(id)){
                return topology;
            }
        }
        return null;
    }
    /**
     * Deleting a topology with a specific id
     *
     * @param id specified topology id
     * @return    true on finding a topology with the same id
     * @return false on no match
     */
    @Override
    public boolean deleteTopology(String id) {
        for(int i=0;i<topologies.size();i++){
            if(topologies.get(i).getId().equals(id)){
                topologies.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Component> getAllDevicesOfTopology(Topology topology) {
        if(topology==null)
            return null;
        return topology.getComponents();
    }

    @Override
    public void printAllDevicesOfTopology(ArrayList<Component> components) {
        if(components==null)
            return;
        System.out.println("Current Devices:");
        for(Component component:components){
            System.out.println(component.getId());
        }
    }

    @Override
    public Component getComponent(ArrayList<Component> components,String id) {
        if(components==null)
            return null;
        for(Component component:components){
            if(component.getId().equals(id)){
                return component;
            }
        }
        return null;
    }


    @Override
    public HashMap<String, String> getNetList(Component component) {
        if(component==null)
            return null;
        return component.getNetList();
    }

    @Override
    public void printNetList(HashMap<String, String> netList) {
        if(netList==null)
            return;
        int order=1;
        for(String name:netList.keySet()){
            String value=netList.get(name);
            System.out.println(String.valueOf(order++)+")"+" "+name+" : "+value);
        }
    }
}
