package org.example.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class UVA10667 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int b = sc.nextInt();
            int [][] arr = new int[b][b];
            for(int [] a : arr){
                Arrays.fill(a, 1);
            }
            int [][] dp = new int[b][b];
            int q = sc.nextInt();
            while(q -- > 0) {
                int x1,y1,x2,y2;
                x1 = sc.nextInt();
                y1 = sc.nextInt();
                x2 = sc.nextInt();
                y2 = sc.nextInt();
                for(int i = x1-1; i<x2; i++){
                    for(int j = y1-1; j<y2; j++){
                        arr[i][j] = -100000;
                    }
                }
            }


            for(int i = 0; i<b; i++) {
                for(int j =0; j<b; j++){
                    dp[i][j] = arr[i][j];
                    if(i > 0) dp[i][j] += dp[i-1][j];
                    if(j > 0) dp[i][j] += dp[i][j-1];
                    if(i > 0 && j > 0) dp[i][j] -= dp[i-1][j-1];
                }
            }
            int ans = Integer.MIN_VALUE;
            for(int i = 0; i<b; i++) {
                for(int i1 =i; i1<b; i1++){
                    int val = 0;
                    for(int j =0; j<b; j++) {
                        int curr = dp[i1][j];
                        if (i > 0) curr -= dp[i - 1][j];
                        if (j > 0) curr -= dp[i1][j - 1];
                        if (i > 0 && j > 0) curr += dp[i - 1][j - 1];
                        val += curr;
                        ans = Math.max(ans, val);
                        if(val < 0) val = 0;
                    }
                }
            }
            if(ans == -100000) System.out.println("0");
            else System.out.println(ans);

        }
    }

}
