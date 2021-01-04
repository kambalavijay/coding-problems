package org.letsonlycode.kambv;

public class FizzBuz {
    int a = 10;
    int b = 20;

    public String isFuzzBuzz(int number){
        if(number % 5 == 0 && number % 3 == 0){
            return "FizzBuzz";
        }
        else if(number % 5 == 0){
            return "Fizz";
        }
        else if(number % 3 == 0){
            return "Buzz";
        }
        else {
            return "No";
        }
    }
}
