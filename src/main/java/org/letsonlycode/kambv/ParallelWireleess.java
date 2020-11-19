package org.letsonlycode.kambv;

import java.util.HashMap;
import java.util.Map;

public class ParallelWireleess {

    public static void main(String[] args) {

        Map map = new HashMap<Integer, String>();

        prepareIntMap(map);

        String str = "I own 2 iPhones & 2 SamSung, i bought it from USA";
        String expected = "I own two i_phones & two Sam_sung, i bought it from USA";

        String [] strArr = str.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strArr.length; i++) {
            boolean isInt = false;
            int s = -1;
            try {
                s = Integer.valueOf(strArr[i]);
                isInt = true;
            }
            catch (Exception e){

            }

            if(isInt){
                sb.append(map.get(s).toString().toLowerCase()).append(" ");
            }
            else{
                String newStr = "";
                int count = 1;
                newStr = newStr + strArr[i].charAt(0);
                for (int j = 1; j < strArr[i].length(); j++) {
                    if(Character.isUpperCase(strArr[i].charAt(j))
                        /*strArr[i].charAt(j) >= 65 && strArr[i].charAt(j) <= 90*/){
                        newStr = newStr + "_" + (char)((int)strArr[i].charAt(j) + 32);
                        count++;
                    }
                    else{
                        newStr = newStr + strArr[i].charAt(j);
                    }
                }
                if(count == strArr[i].length()){
                    sb.append(strArr[i]).append(" ");
                }
                else{
                    sb.append(newStr).append(" ");
                }
            }
        }

        System.out.println(sb.toString());

    }

    static void prepareIntMap(Map<Integer, String> m){
        m.put(0, "Zero");
        m.put(1, "One");
        m.put(2, "Two");
        m.put(3, "Three");
        m.put(4, "Four");
        m.put(5, "Five");
        m.put(6, "Six");
        m.put(7, "Seven");
        m.put(8, "Eight");
        m.put(9, "Nine");
    }
}
