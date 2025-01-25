package org.example;

import java.util.Scanner;

public class UVA147 {

    public static long [][] dp = new long[12][30001];

    public static long calculatePossibleWays(int [] coins, int sum, int ind) {


        // recursive way to solve the problem.

        // if(ind < 0 ||  sum < 0) {
        //     return 0;
        // }
        // if(sum == 0) {
        //     return 1;
        // }

        // long notTake = calculatePossibleWays(coins, sum, ind-1);
        // long take = 0;
        // if(sum >= coins[ind])
        // take = calculatePossibleWays(coins, sum-coins[ind], ind);
        // return (take + notTake);

        

        for(int i = 0; i<ind; i++) dp[i][0] = 1;

        for(int i=1; i<=ind; i++) {
            for(int j = 0; j<= sum; j++) {
                long notTake = dp[i-1][j];
                long take = 0;
                if(j >= coins[i-1]) {
                    take = dp[i][j-coins[i-1]];
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[11][sum];

    }
    public static void main(String args []) {
        Scanner sc = new Scanner(System.in);
        int [] dimensions = new int[11];
        dimensions[0] = 10000;
        dimensions[1] = 5000;
        dimensions[2] = 2000;
        dimensions[3] = 1000;
        dimensions[4] = 500;
        dimensions[5] = 200;
        dimensions[6] = 100;
        dimensions[7] = 50;
        dimensions[8] = 20;
        dimensions[9] = 10;
        dimensions[10] = 5;
        calculatePossibleWays(dimensions, 30000, 11);

        
        while(true) {
            double val = sc.nextDouble();
            if(val == 0.0) break;
            int value = (int)(val*100+0.5);
            
            System.out.printf("%6.2f%17d\n",val, dp[11][value]);
        }
    }
}
