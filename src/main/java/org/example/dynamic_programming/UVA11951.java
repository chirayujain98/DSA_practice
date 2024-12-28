package org.example.dynamic_programming;

import java.util.Scanner;

public class UVA11951 {

    // TLE solution below when applied Kadane like other will give AC according to me but can try while revision.
    public static void main(String args []) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int test = 1;
        while(t-- > 0) {
            int n,m;
            long k;
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextLong();
            int [][] arr = new int[n][m];
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int [][] dp = new int[n][m];
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    dp[i][j] = arr[i][j];
                    if(i > 0) dp[i][j] += dp[i-1][j];
                    if(j > 0) dp[i][j] += dp[i][j-1];
                    if(i > 0 && j > 0) dp[i][j] -= dp[i-1][j-1];
                }
            }

            long  area = 0;
            long  cost = Long.MAX_VALUE;
            for(int i = 0; i<n; i++){
                for(int i1 = i; i1<n; i1++){
                    for(int j = 0; j<m; j++){
                        for(int j1 = j; j1 <m; j1++) {
                            int curr = dp[i1][j1];
                            if(i > 0) curr -= dp[i-1][j1];
                            if(j > 0) curr -= dp[i1][j-1];
                            if(i > 0 && j > 0) curr += dp[i-1][j-1];
                            if(curr <= k && area <= (i1-i+1)*(j1-j+1)){
                                if(area == ((i1-i+1)*(j1-j+1)))
                                    cost = Math.min(cost, curr);
                                else cost = curr;
                                area =  (i1-i+1)*(j1-j+1);
                            }
                        }
                    }
                }
            }
            if(cost == Long.MAX_VALUE) System.out.println("Case #" + test+ ": " + area + " " + "0");
            else System.out.println("Case #" + test+ ": " + area + " " + cost);
            test++;
        }
    }

}
