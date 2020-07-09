package org.letsonlycode.kambv;

import java.util.Arrays;

public class SplitExample{
   public static void main(String args[]){
       String str = new String("28/12/2013");
       System.out.println("split(String regex):");
       String array1[]= str.split("/");
       System.out.println(Arrays.toString(array1));
       System.out.println("split(String regex, int limit) with limit=2:");
       String array2[]= str.split("/", 2);
       System.out.println(Arrays.toString(array2));
       System.out.println("split(String regex, int limit) with limit=0:");
       String array3[]= str.split("/", 0);
       System.out.println(Arrays.toString(array3));
       System.out.println("split(String regex, int limit) with limit=-5:");
       String array4[]= str.split("/", -5);
       System.out.println(Arrays.toString(array4));
   }
}