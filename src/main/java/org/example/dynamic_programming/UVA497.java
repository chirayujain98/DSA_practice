package org.example.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UVA497 {
    public static void LIS(List<Integer> altitudes, int t) {
        int n = altitudes.size();
        int[] dp = new int[n];
        int[] prev = new int[n];  // Store previous missile index for backtracking
        
        // Initialize
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }
        
        // Find longest sequence
        int maxLength = 1;
        int endIndex = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(altitudes.get(i) > altitudes.get(j) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                    if(dp[i] > maxLength) {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }
        
        // Reconstruct sequence
        List<Integer> sequence = new ArrayList<>();
        for(int i = endIndex; i != -1; i = prev[i]) {
            sequence.add(altitudes.get(i));
        }
        Collections.reverse(sequence);
        
        // Output results
        System.out.println("Max hits: " + maxLength);
        for(int altitude : sequence) {
            System.out.println(altitude);
        }
        if(t != 0) System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        sc.nextLine();
        while(t-- > 0) {
            String line;
            List<Integer> list = new ArrayList<>();
            while(sc.hasNextLine() && !(line = sc.nextLine()).isEmpty()) {
                list.add(Integer.parseInt(line));
            }
            LIS(list, t);
        }
        sc.close();
    }
}
