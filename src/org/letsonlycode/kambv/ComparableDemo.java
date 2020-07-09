package org.letsonlycode.kambv;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableDemo {
	
	public static void main(String[] args) {
		
		String a = "Vijay";
		
		char[] a1 = a.toCharArray();
		
		Character[] c = new  Character[a1.length];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = a.charAt(i);
		}
				
		List<Character> l = Arrays.asList(c);
			
		Collections.sort(l, new CharIgnoreCaseComparator());

		for (int i = 0; i < l.size(); i++) {
			a1[i] = l.get(i);
		}
		
		System.out.println(a1);
	}
}


class CharIgnoreCaseComparator implements Comparator<Character> {

	@Override
	public int compare(Character o1, Character o2) {
		Character c1 = Character.toLowerCase(o1);
		Character c2 = Character.toLowerCase(o2);
		return c1 - c2;
	}
} 