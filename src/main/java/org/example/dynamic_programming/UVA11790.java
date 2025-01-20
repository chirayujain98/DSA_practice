package org.example.dynamic_programming;

import java.util.Scanner;



public class UVA11790 {

    public static int[] lis(int[] height, int[] width) {
        int n = height.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = width[i];
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(height[j] < height[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + width[i]);
                }
            }
        }
        return dp;
    }

    public static int[] lds(int[] height, int[] width) {
        int n = height.length;
        for(int i = 0; i < n; i++) {
            height[i] = -height[i];
        }
        int[] dp = lis(height, width);
    
        return dp;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] height = new int[n];
            for(int j = 0; j < n; j++) {
                height[j] = sc.nextInt();
            }
            int[] width = new int[n];
            for(int j = 0; j < n; j++) {
                width[j] = sc.nextInt();
            }

            int[] lis = lis(height, width);
            int[] lds = lds(height, width);
            int increasing = Integer.MIN_VALUE;
            int decreasing = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++) {
                increasing = Math.max(increasing, lis[j]);
                decreasing = Math.max(decreasing, lds[j]);
            }
            if(increasing >= decreasing) {
                System.out.println("Case " + (i+1) + ". Increasing (" + increasing + "). Decreasing (" + decreasing + ").");
            } else {
                System.out.println("Case " + (i+1) + ". Decreasing (" + decreasing + "). Increasing (" + increasing + ").");
            }
        }
    }
}
