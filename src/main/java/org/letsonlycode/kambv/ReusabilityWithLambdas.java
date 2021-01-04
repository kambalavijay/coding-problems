package org.letsonlycode.kambv;

import com.sun.tools.javac.util.List;
import java.util.function.Predicate;

public class ReusabilityWithLambdas {

    public static int total(List<Integer> values, Predicate<Integer> integerPredicate){
        int total = 0;
        for (Integer ele : values) {
            if(integerPredicate.test(ele)){
                total+=ele;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        List<Integer> values = List.of(1,2,3,4,5,6,7,8,9);
        Predicate<Integer> globalPredicate = (Integer ele) -> true;
        int allTotal = total(values, globalPredicate);

        System.out.println(allTotal);

        Predicate<Integer> evenPredicate = (Integer ele) -> ele % 2 == 0;
        int evenTotal = total(values, evenPredicate);

        System.out.println(evenTotal);

        Predicate<Integer> oddPredicate = (Integer ele) -> ele % 2 != 0;
        int oddTotal = total(values, oddPredicate);

        System.out.println(oddTotal);
    }
}
