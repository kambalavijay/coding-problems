package org.letsonlycode.kambv;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OraclePattern {
    public static void main(String[] args) {

        String str = "oracle india pvt ltd";

        /*
        oipl
        oripl
        orinpl
        orinpvl
        orinpvlt
        orainpvlt
        oraindpvlt
        oraindpvtlt
        oraindpvtltd
        oracindpvtltd
        oracindipvtltd
        oraclindipvtltd
        oraclindiapvtltd
        oracleindiapvtltd
        */
        // [oracle, india, private, ltd]
        String[] arr = str.split(" ");
        String endString = String.join("", arr); // oracleindiaprivateltd
        String[] patternArr = new String[arr.length];

        Arrays.fill(patternArr, "");
        patternArr = (String[]) (Arrays.stream(patternArr).map(str1 -> "").collect(Collectors.toList())).toArray(new String[0]);

        String patternString = String.join("", patternArr);
        int j = 1;
        int i = 0;
        int count = arr.length;
        boolean skip = false;

        while(!patternString.equals(endString)){
            for(; i < count; i++){
                if(j <= arr[i].length()){
                    patternArr[i] = arr[i].substring(0, j);
                }
                if(j > arr[i].length()){
                    skip = true;
                    break;
                }
            }
            if(count == arr.length){
                count = 1;
                j++;
            }
            else{
                count++;
            }
            i = count - 1;
            if(skip){
                skip = false;
                continue;
            }
            patternString = String.join("", patternArr);
            System.out.println(patternString);
        }
    }
}
