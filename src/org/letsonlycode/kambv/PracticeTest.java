package org.letsonlycode.kambv;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PracticeTest {

	public static void main(String[] args) {


		String pattern = "a*bc*d";
		String str = "abbcdd";
		int i = 0, j = 0;
		boolean isMatch = true;

		while (i < pattern.length() && j < str.length()){
			if(pattern.charAt(i) == str.charAt(j)){
				i++;
				j++;
				continue;
			}
			else if(pattern.charAt(i) == '*'){
				i++;
				if(pattern.charAt(i) == str.charAt(j)){
					j++;
					i++;
					while(j < str.length() && str.charAt(j) == str.charAt(j-1)){
						j++;
					}
				}
				// if it is not matching with char after * then it means it is matching with the *
				else if(pattern.charAt(i) != str.charAt(j)){
					j++;
					while(j < str.length() && str.charAt(j) == str.charAt(j-1)){
						j++;
					}
					if(str.charAt(j) != pattern.charAt(i)){
						isMatch = false;
						break;
					}
					else{
						i++;
						j++;
					}
				}
			}
			else{
				isMatch = false;
				break;
			}
		}

		if(pattern.length() - j > 0)  {
			isMatch = false;
		}
		System.out.println(isMatch);
	}
}


class Permutation{

	void permutate(String str){
		permutate(str, "");
	}

	void permutate(String str, String ans){
		if(str.isEmpty()){
			System.out.println(ans);
		}

		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i+1);
			permutate(ros, ans + c);
		}
	}
}