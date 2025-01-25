package org.example.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UVA990 {


    public static void knapSack(int []d, int []v, int t, int n, int w) {

        int[][] dp = new int[n][t + 1];
        int[][] trace = new int[n][t + 1]; // To track selected items

        for(int i = d[0]; i<=t; i++) {
            trace[0][i] = 1;
            dp[0][i] = v[0];
        }
        for(int i=1; i<n; i++){
            for(int j = 0; j<=t; j++){
                int nt = dp[i-1][j];
                int ta = Integer.MIN_VALUE;
                if(d[i] <= j) {
                    ta = v[i]+ dp[i-1][j-d[i]];
                }
                if(ta > nt) {
                    trace[i][j] = 1;
                }
                dp[i][j] = Math.max(nt,ta);
            }
        }
       


        // Backtrack to find the selected items
        List<Integer> items = new ArrayList<>();
        int remainingTime = t;
        for (int i = n - 1; i >= 0; i--) {
            if (trace[i][remainingTime] == 1) {
                items.add(i);
                remainingTime -= d[i];
            }
        }

        // Output the result
        System.out.println(dp[n-1][t]); // Maximum value
        System.out.println(items.size()); // Number of items selected
        Collections.reverse(items); // To print items in the correct order
        for (Integer item : items) {
            System.out.println(d[item] / (3 * w) + " " + v[item]);
        }

    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        boolean first = true;
        while(sc.hasNext()) {
            if(!first) {
                System.out.println();
            }
            first = false;

            int t = sc.nextInt();
            int w = sc.nextInt();

            int n = sc.nextInt();
            int [] d = new int[n];
            int [] v = new int[n];

            for(int i = 0; i<n;i++) {
                int dd = sc.nextInt();
                d[i] = 3*w*dd;
                v[i] = sc.nextInt();
            }

            knapSack(d,v,t,n,w);

            if(sc.hasNextLine()) sc.nextLine();
        }
    }
    
}
