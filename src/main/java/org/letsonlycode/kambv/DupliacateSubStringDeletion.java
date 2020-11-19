package org.letsonlycode.kambv;

import java.util.ArrayList;
import java.util.List;

public class DupliacateSubStringDeletion {

    public static void main(String[] args) {

        //String a = "abcdeabcfghbaaklcyz";
        String a = "abcc";

        int charLastIndexTracker[] = new int[256];

        for (int i = 0; i < charLastIndexTracker.length; i++) {
            charLastIndexTracker[i] = -1;
        }

        List indicesToRemove = new ArrayList<>();

        for (int i = 0; i < a.length(); i++) {
            int currCharIntEquivalent = (int)a.charAt(i);
            if((charLastIndexTracker[currCharIntEquivalent] + 1) != 0){
                indicesToRemove.add(i);
            }
            else{
                charLastIndexTracker[currCharIntEquivalent] = i;
            }
        }

        System.out.println(indicesToRemove);

        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            if(!indicesToRemove.contains(i)){
                newString.append(a.charAt(i));
            }
        }

        System.out.println(newString);
    }
}
