package org.letsonlycode.kambv;

public class ChargeBee {
    public static void main(String[] args) {

        int n1 = 2;
        int n2 = 4;
        int superCount  = 0;
        int fistNum = Integer.parseInt(n1 + "000000");
        int lastNum = Integer.parseInt(n2 + "235959");
        if(lastNum < Integer.MAX_VALUE){
            while(lastNum >= fistNum){

                int secondsFirstDig = lastNum % 10;
                lastNum = lastNum / 10;
                int seconds = (lastNum % 10) * 10 + secondsFirstDig;
                if(seconds > 59){
                    continue;
                }

                String strRepOfInt = lastNum + "";

                int i = 0;
                int j = strRepOfInt.length() - 1;
                int count = 0;
                while(i < j && strRepOfInt.charAt(i) == strRepOfInt.charAt(j)){
                    count+=2;
                    i++;
                    j--;
                }
                if(strRepOfInt.length() == (count + 1)){
                    superCount++;
                    System.out.println(strRepOfInt);
                }
                lastNum--;
            }
        }

        // 4235958
        // 3333333
    }
}

