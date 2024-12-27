package org.example.dynamic_programming;

import java.util.Scanner;

public class UVA10755 {
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int a  = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            long [][][] dp = new long[a][b][c];
            for(int i = 0; i<a; i++) {
                for(int j = 0; j<b; j++) {
                    for(int k = 0; k<c; k++) {
                       long s = sc.nextLong();
                       if(i > 0) s += dp[i-1][j][k];
                       if(j > 0) s += dp[i][j-1][k];
                       if(k > 0) s += dp[i][j][k-1];
                       if(i > 0 && j > 0) s -= dp[i-1][j-1][k];
                       if(j > 0 && k > 0) s -= dp[i][j-1][k-1];
                       if(i > 0 && k > 0) s -= dp[i-1][j][k-1];
                       if(i > 0 && j > 0 && k > 0) s += dp[i-1][j-1][k-1];
                       dp[i][j][k] = s;
                    }
                }
            }
            long curr = 0;
            long sum = Long.MIN_VALUE;
            for(int i = 0; i<a; i++) {
                for(int j = 0; j<b; j++) {
                    for(int i1 = i; i1<a; i1++) {
                        for(int j1 = j; j1<b; j1++){
                            long val = 0;
                            for(int k = 0; k<c; k++){
                                    curr = dp[i1][j1][k];
                                    if(i>0) curr -= dp[i-1][j1][k];
                                    if(j>0) curr -= dp[i1][j-1][k];
                                    if(k>0) curr -= dp[i1][j1][k-1];
                                    if(i > 0 && j > 0) curr += dp[i-1][j-1][k];
                                    if(j > 0 && k > 0) curr += dp[i1][j-1][k-1];
                                    if(i > 0 && k > 0) curr += dp[i-1][j1][k-1];
                                    if(i > 0 && j > 0 && k > 0) curr -= dp[i-1][j-1][k-1];
                                    sum = Math.max(sum,(val + curr));
                                    val = val+curr;
                                    if(val < 0) val = 0;

                            }
                        }
                    }
                }
            }
            System.out.println(sum);
            if(t!=0)
            System.out.println("");
        }
    }
}
