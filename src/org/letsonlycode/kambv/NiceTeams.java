package org.letsonlycode.kambv;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NiceTeams {

    public static int maxPairs(List<Integer> skillLevel, int minDiff) {
        // Write your code here
        int n = skillLevel.size();

        int count = 0;
        Set<Point> pairs = new HashSet<>();

        for(int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++) {
                int absDiff = Math.abs(skillLevel.get(i) - skillLevel.get(j));
                Point p = new Point(skillLevel.get(i), skillLevel.get(j));
                if(absDiff >= minDiff && !pairs.contains(p)){
                    count++;
                    pairs.add(p);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List l = new ArrayList();
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(2);
        l.add(1);
        l.add(1);

        System.out.println(maxPairs(l, 3));
    }
}
