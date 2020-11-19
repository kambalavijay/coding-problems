package org.letsonlycode.kambv;

import java.util.Arrays;

public class PermutationsWithRepetition {
		// function to remove all occurrences 
	    // of an element from an array 
	    public static int[] removeElements(int[] arr, int key) {
	          // Move all other elements to beginning  
	          int index = 0; 
	          for (int i = 0; i < arr.length; i++) {
	        	  if (arr[i] != key) 
	        		  arr[index++] = arr[i];
	        	  
	        	 // System.out.println(Arrays.toString(arr));
	          }
	         // Create a copy of arr[]  
	         return Arrays.copyOf(arr, index);
	    }
	  
	    // Driver code 
	    public static void main(String[] args) {
	        int[] array = { 3, 9, 2, 3, 1, 7, 2, 3, 5}; 
	        int key = 3; 
	        
	        System.out.println(Arrays.toString(array));
	        
	        int[] array1 = removeElements(array, key); 
	        
	        		
	        System.out.println(Arrays.toString(array));
	        System.out.println(Arrays.toString(array1));
	    } 
	
}	