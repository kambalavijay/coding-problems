package org.letsonlycode.kambv;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxProfit {

    public static void main(String[] args) {

        int prices[] = {5, 4, 3, 2, 9, 1, 7};

        int profit = 0;
        int currMax = prices[0];
        int currMin = prices[0];

        for (int i = 1; i < prices.length-1; i++) {
            if(prices[i] > currMax){
                currMax = prices[i];
            }
            if(prices[i] < currMin){
                currMin = prices[i];
            }
            if((prices[i-1] > prices[i] && prices[i] < prices[i+1]) ||
                    (prices[i-1] < prices[i] && prices[i] > prices[i+1]) ){
                currMax = prices[i+1] > currMax ? prices[i+1] : currMax;
                profit = profit + (currMax - currMin);
                currMax = Integer.MIN_VALUE;
                currMin = Integer.MAX_VALUE;
            }
        }
        System.out.println(profit);
    }
}
