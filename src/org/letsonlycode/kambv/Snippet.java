package org.letsonlycode.kambv
;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snippet {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        int M = Integer.parseInt(inp.readLine());
        String[] inputArr = inp.readLine().trim().split(" ");
        if(M >= 1 && M < (Math.pow(2, 32) - 1)) {
            System.out.println(((inputArr.length - M) >= 0) ? inputArr[inputArr.length - M] : "NIL");
        }
		
	}
}

