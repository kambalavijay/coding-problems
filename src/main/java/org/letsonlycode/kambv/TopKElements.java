package org.letsonlycode.kambv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {

    private PriorityQueue maxHeap = new PriorityQueue(Collections.reverseOrder());

    public List<Integer> getTopK(int n){
        List topKnum = new ArrayList();
        maxHeap.add(n);

        int initSize = maxHeap.size();

        for (int i = 0; i < n && i < initSize; i++) {
            topKnum.add(maxHeap.poll());
        }

        for (int i = 0; i < topKnum.size(); i++) {
            maxHeap.add(topKnum.get(i));
        }

        return topKnum;
    }


    public static void main(String[] args) {
        TopKElements topKElements = new TopKElements();
        System.out.println(topKElements.getTopK(1));
        System.out.println(topKElements.getTopK(9));
        System.out.println(topKElements.getTopK(3));
        System.out.println(topKElements.getTopK(1));
    }
}
