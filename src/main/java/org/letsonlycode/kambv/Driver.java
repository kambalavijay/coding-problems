package org.letsonlycode.kambv;

import org.json.simple.JSONObject;

import java.util.Deque;
import java.util.LinkedList;

public class Driver{

    public static void main(String[] args) {


        Deque deque = new LinkedList();

        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);

        System.out.println(deque.getFirst());
    }
}