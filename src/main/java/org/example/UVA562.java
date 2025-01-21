package org.example;

import java.util.Scanner;

public class UVA562 {


    public static int knapSack(int [] arr, int n, int sum) {
        boolean [] dp = new boolean[sum+1];
        dp[0] = true;
        int target = sum/2;
        for(int coin :  arr) {
            for(int j = target; j>= coin; j--) {
                dp[j] |= dp[j-coin];
            }
        }
        int max = 0;
        for(int i = 0; i<= sum; i++){
            if(dp[i]) max = i;
        }
        return max;
    }
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int [] arr = new int[n];
            int sum = 0;
            for(int i = 0; i<n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }

            int diff = knapSack(arr, n, sum);
            System.out.println(sum -2*diff);
        }
    }
}
