package org.example.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

/*
The problem for dp pattern LIS
 */
public class UVA111 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();  // Consume the leftover newline
        
        // Read the correct chronological order
        int[] correctPos = new int[n + 1];
        String[] correctStr = sc.nextLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            int event = i + 1;
            int position = Integer.parseInt(correctStr[i]);
            correctPos[position] = event;
        }
        
        // Read student answers until end of input
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            
            // Parse student's answer
            String[] studentStr = line.split("\\s+");
            int[] studentPos = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int event = i + 1;
                int position = Integer.parseInt(studentStr[i]);
                studentPos[position] = event;
            }
            
            // Create sequence for LIS
            int[] sequence = new int[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = getPosition(correctPos, studentPos[i + 1], n);
            }
            
            // Find LIS length
            System.out.println(findLIS(sequence));
        }
    }

    private static int getPosition(int[] correctPos, int event, int n) {
        for (int i = 1; i <= n; i++) {
            if (correctPos[i] == event) return i;
        }
        return 0;
    }

    private static int findLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
