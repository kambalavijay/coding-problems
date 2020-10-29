package org.letsonlycode.kambv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Snippet {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

        String S = "ababa";
        int N = 5;
        int K = 2;

            Map<String, Integer> map = new HashMap<String, Integer>();

            for(int i = 0; i <= N - K; i++){
                    if(map.get(S.substring(i, i+K)) == null){
                            map.put(S.substring(i, i+K), 1);
                    }
                    else{
                            int value  = map.get(S.substring(i, i+K)) + 1;
                            map.put(S.substring(i, i+K), value);
                    }
            }


            int size = 0;
            double total = 0.0;


            for(Map.Entry<String, Integer> item : map.entrySet()){
                    total = total + (item.getValue() * item.getValue());
                    size  = size + item.getValue();
            }



            System.out.println((long)((total/size) % 998244353));

    }
}

