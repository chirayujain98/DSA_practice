package org.example.dynamic_programming;

import java.util.Scanner;

public class UVA108 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [][] arr = new int[t][t];
        for(int i = 0; i<t; i++) {
            for(int j = 0; j<t; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = Integer.MIN_VALUE;
        int [][] dp = new int[t][t];
        for(int i = 0; i<t; i++) {
            for(int j = 0; j<t; j++){
                dp[i][j] = arr[i][j];
                if(i > 0) dp[i][j] += dp[i-1][j];
                if(j > 0) dp[i][j] += dp[i][j-1];
                if(i > 0 && j > 0) dp[i][j] -= dp[i-1][j-1];

            }
        }

        for(int i =0; i<t; i++){
            for(int i1 = i; i1<t; i1++){
                int sum = 0;
                for(int j = 0; j<t; j++) {
                        int curr = dp[i1][j];
                        if(i>0) curr -= dp[i-1][j];
                        if(j>0) curr -= dp[i1][j-1];
                        if(i > 0 && j > 0) curr += dp[i-1][j-1];
                        sum += curr;

                        ans = Math.max(ans, sum);
                        if(sum < 0) sum = 0;
                }
            }
        }
        System.out.println(ans);
    }
}
