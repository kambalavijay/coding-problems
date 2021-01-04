package org.letsonlycode.kambv;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
static Scanner scanner = new Scanner(System.in);
static int B = scanner.nextInt();
static int H = scanner.nextInt();
static boolean flag = false;
static{
    flag = (B <=0 || H <= 0) ? false : true;
}

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		else{
			System.out.print("java.lang.Exception: Breadth and height must be positive");
		}
		
	}//end of main

}//end of class

