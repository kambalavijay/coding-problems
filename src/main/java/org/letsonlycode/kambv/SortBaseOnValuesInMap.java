package org.letsonlycode.kambv;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortBaseOnValuesInMap {

    /**
    * 
    * @param args
    */
    public static void main(String[] args) {

        Map<String, Integer> hm = new HashMap();
        hm.put("Naveen", 2);
        hm.put("Santosh", 3);
        hm.put("Ravi", 4);
        hm.put("Pramod", 1);
        hm.put("Vijay", 5);
        
        List<Entry<String, Integer>> list = new ArrayList(hm.entrySet());
        
        System.out.println("before \n" + list);

        List sortedList = list.stream().sorted(Comparator.comparing(Entry::getValue)).collect(Collectors.toList());

        System.out.println("after \n" + sortedList);
    }
}
