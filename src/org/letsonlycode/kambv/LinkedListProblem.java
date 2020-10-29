package org.letsonlycode.kambv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LinkedListProblem {

    public static void main(String[] args) {

        // a -> b -> a -> a -> c -> d - > c

       /* LinkedList<S> linkedList = new LinkedList<S>();
        linkedList.insertData('d');
        linkedList.insertData('d');
        linkedList.insertData('a');
        linkedList.insertData('a');
        linkedList.insertData('a');
        linkedList.insertData('c');

        Map<Character, Integer> freq = new HashMap<Character, Integer>();

        Node head = linkedList.head;
        Node temp = head;

        while(temp != null){
            System.out.println(temp.getData());
            if(freq.containsKey(temp.getData())){
                freq.put(temp.getData(), freq.get(temp.getData())+1);
            }
            else{
                freq.put(temp.getData(), 1);
            }
            temp = temp.getNextNode();
        }

        System.out.println(freq);

        List<Map.Entry<Character, Integer>> list = freq.
                entrySet().
                stream().
                sorted((Map.Entry<Character, Integer>o1, Map.Entry<Character, Integer>o2) -> o2.getValue() - o1.getValue()).
                collect(Collectors.toList());

        System.out.println(freq);

        System.out.println(list.get(0).getKey());*/
    }

}

class Node {
    private char data;

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    private Node nextNode;

    public Node(char data, Node nextNode){
        this.data = data;
        this.nextNode = nextNode;
    }
}

class LinkedList<S> {

    Node head;

    public LinkedList(){
        head = null;
    }

    public void insertData(char ele){
        if(head == null){
            Node n = new Node(ele, null);
            head = n;
        }
        else{
            Node temp = head;
            while (temp.getNextNode() != null){
                temp = temp.getNextNode();
            }
            temp.setNextNode(new Node(ele, null));
        }
    }


}