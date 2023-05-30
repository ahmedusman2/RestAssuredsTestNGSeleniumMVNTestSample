package com.lamdatest.webpages;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
    public static JsonPath rawStringToJson(String response){
        JsonPath jp = new JsonPath(response);
        return jp;
    }

    public static void main(String[] args) {
        // Your main method code goes here
    }
}
