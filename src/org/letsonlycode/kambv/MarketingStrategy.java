package org.letsonlycode.kambv;

import java.util.Arrays;

/*
 Manipulate the given string in such a way that no two alternate characters are same(when you replace S wit R or R with S count it as swap)
 and in case after arranging them alternatively if still there S R left over serially then we need to convert them their counterparts(count it as swap) to make
 sure the manipulated string definitely has alternate characters.

 Input  : RRRRR
 Output : RSRSR   swap -> 2(since we have converted the first and third positions to S)
* */
public class MarketingStrategy {

    public static void main(String[] args) {

        String s = "RSSRRSSR";

        char stringArray[] = s.toCharArray();
        int n = s.length();
        int slow = 0;
        int fast = 1;

        int count = 0;
        while(fast < n){
            if(stringArray[slow] == stringArray[fast]){
                fast++;
            }
            else if(stringArray[slow]!= stringArray[fast]){
                if(slow + 1 == fast){
                    slow++;
                    fast++;
                }
                else{
                    slow++;
                    char c = stringArray[slow];
                    stringArray[slow] = stringArray[fast];
                    stringArray[fast] = c;
                    fast = slow + 1;
                    count++;
                }
            }
        }

        if(slow < n){
           char rep = stringArray[slow] == 'R' ? 'S' : 'R';
            while(++slow < n){
                stringArray[slow] = rep;
                count++;
                slow +=1;
            }
        }


        System.out.println(Arrays.toString(stringArray));
        System.out.println(count);

    }
}
