# Topology API
## Table of contents
+ [About](#about)
+ [Functional requirments](#functionalRequirments)
+ [Used Technologies](#usedTechnologies)
+ [Topology API Documentation](#topologyApiDocs)
+ + [Getting started](#gettingStarted)
+ + [Usage](#usage)
 ## 🤷🏻‍♂️ About <a name = "about"></a>
 Provide the functionality to access, manage and store device topologies.
 ## 👮🏻‍♂️ Functional requirments <a name="functionalRequirments"></a>
1. Read a topology from a given JSON file and store it in the memory.
2. Write a given topology from the memory to a JSON file.
3. Query about which topologies are currently in the memory.
4. Delete a given topology from memory.
5. Query about which devices are in a given topology.
6. Query about which devices are connected to a given netlist node in
a given topology.
## 👨🏻‍💻 Used Technologies <a name="usedTechnologies"></a>
- [IntelliJ](https://www.jetbrains.com/idea/) - integrated development environment 
- [Junit 5](https://junit.org) - Testing framework
- [Json parser](https://github.com/stleary/JSON-java) - Json parser package
- [Maven](https://maven.apache.org/) - as a building tool
## 📄 Topology API Documentation<a name = "topologyApiDocs"></a>
### 🏁 Getting started <a name = "gettingStarted"></a>
First, you need to create an instance of TopologyApi class
```
TopologyApi topologyApi=TopologyApi.createTopologyApi();
```
Second, read the topology json file
```
topologyApi.topologyApiUtilities.readJson(defaultPath);
```
### 🎯 Usage <a name = "usage"></a>
Get all topologies from memory:
```
ArrayList<Topology> topologies=topologyApi.topologyApiUtilities.getTopologies();
```
Delete a topology with Id from memory, return **true** on successfull deletion, **false** if not found:
```
Boolean isDeleted=topologyApi.topologyApiUtilities.deleteTopology("top1");
```
Query about which devices are in a given topology:
```
Topology topology=topologyApi.topologyApiUtilities.getTopology("top1");
ArrayList<Component> components=topology.getComponents();
```
Query about which devices are connected to a given netlist node in
a given topology:
```
 Component component=topologyApi.topologyApiUtilities.getComponent(components,"res1");
 HashMap<String,String>devices=topologyApi.topologyApiUtilities.getNetList(component);
```
Write a given topology from the memory to a JSON file, return **true** on successfull writing operation, **false** on failure :
```
 topologyApi.topologyApiUtilities.writeJson(topology,outputPath);
```
