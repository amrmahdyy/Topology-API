package com.company;

import com.company.Topology.APIs.JsonParser;

import java.nio.file.Path;

public class Main {
   public static String defaultPath="/Users/test/Desktop/Web development projects/Master Micro assignment/JsonDemo/src/com/company/topology.json";

    public static void main(String[] args) {
	// write your code here
        JsonParser jsonParser=new JsonParser();
        jsonParser.readJson(defaultPath);
    }
}
