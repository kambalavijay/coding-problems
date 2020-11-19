package org.letsonlycode.kambv;

import org.json.simple.JSONObject;

public class Driver{

    public static void main(String[] args) {

        JSONObject json = new JSONObject();
        json.put("car", "Vijay's Car");

        System.out.println(json);
    }
}