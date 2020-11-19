package org.letsonlycode.kambv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubStringKSize {
	
	public static void printSmallestAndLargest(String s, int k)
    {
		if(s.length() >= k) {
			String min = s.substring(0, k);
			String max = s.substring(0, k);
						
			for(int i = 1; i < ( s.length() - k + 1 ); i++) {
				
				String nextItem = s.substring(i, i+k);
				
				if(nextItem.compareTo(min) < 0) {
					min = nextItem;
					continue;
				}
				else if(nextItem.compareTo(max) > 0) {
					max = nextItem;
					continue;
				}
			}
			
			System.out.println("Min: " + min);
			System.out.println("Min: " + max);
		}
		else {
			System.out.println("Invalid inputs...");
		}
    }
	
	public static List<String> getSmallestAndLargest(String s, int k) 
    {
		List<String> kSizeSubStringList = new ArrayList<String>();
		for(int i = 0; i < s.length() - k; i++) {
			kSizeSubStringList.add(s.substring(i, i+k));
		}
		return kSizeSubStringList; 
    }
	
	public static void main(String[] args) {
		
		String str = "GeeksForGeeks";
		int subStringSize = 3;
		
		printSmallestAndLargest(str, subStringSize);
		
		List<String> l = getSmallestAndLargest(str, subStringSize);
		
		System.out.println(l);
		
		Collections.sort(l);
		
		System.out.println(l.get(0));
		System.out.println(l.get(l.size()-1));
		
	}
}


