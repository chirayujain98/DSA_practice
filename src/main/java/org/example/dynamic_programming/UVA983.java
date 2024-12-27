package org.example.dynamic_programming;

import java.util.Scanner;

public class UVA983 {
    public static void main(String args []) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //sc.nextLine();
            if(a == 0 || b == 0) break;
            int [][] arr = new int[a][b];
            for(int i = 0; i<a; i++) {
                for(int j =0; j<b; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int [][] dp = new int[a][b];
            for(int i = 0; i<a; i++){
                for(int j = 0; j<b; j++){
                    if(arr[i][j] == 1){
                        dp[i][j] = -100000;
                    }else{
                        dp[i][j] = 1;
                    }
                    if(i > 0) dp[i][j] += dp[i-1][j];
                    if(j > 0) dp[i][j] += dp[i][j-1];
                    if(i > 0 && j > 0) dp[i][j] -= dp[i-1][j-1];
                }
            }
            int ans = Integer.MIN_VALUE;
            for(int i = 0; i<a; i++){
                for(int i1 = i; i1<a; i1++){
                    int val = 0;
                    for(int j = 0; j<b; j++) {
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
