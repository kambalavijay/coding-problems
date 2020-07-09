package org.letsonlycode.kambv;

import java.util.*;

public class PracticeTest {

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static void main(String[] args) {

		System.out.println(new ConstantImpl1().getRandom());
		System.out.println(new ConstantImpl2().getRandom());
	}
}

class ConstantImpl1 implements Constant1 {

	int getRandom(){
		return randomInt;
	}
}

class ConstantImpl2 implements Constant1 {

	int getRandom(){
		return randomInt;
	}
}

interface Constant1 {

	Random random = new Random();
	int randomInt = random.nextInt(10000);
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