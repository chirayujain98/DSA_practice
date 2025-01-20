package org.example.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class UVA10534 {

    private static int[] getLisLength(int[] arr) {
        int n = arr.length;
        int[] len = new int[n];
        int[] dp = new int[n];
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            // Binary search to find position to insert arr[i]
            int pos = Arrays.binarySearch(dp, 0, maxLen, arr[i]);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            dp[pos] = arr[i];
            if (pos == maxLen) {
                maxLen++;
            }
            len[i] = pos + 1;  // Store the length of LIS ending at i
        }
        return len;
    }

    private static int[] getLdsLength(int[] arr) {
        int n = arr.length;
        int[] len = new int[n];
        int[] dp = new int[n];
        int maxLen = 0;
        
        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Binary search to find position to insert arr[i]
            int pos = Arrays.binarySearch(dp, 0, maxLen, arr[i]);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            dp[pos] = arr[i];
            if (pos == maxLen) {
                maxLen++;
            }
            len[i] = pos + 1;  // Store the length of LDS starting at i
        }
        return len;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] lis = getLisLength(arr);
            int[] lds = getLdsLength(arr);

            int ans = 1;
            for (int i = 0; i < n; i++) {
                // The minimum of LIS and LDS at position i, doubled minus 1
                ans = Math.max(ans, 2 * Math.min(lis[i], lds[i]) - 1);
            }
            System.out.println(ans);
        }
    }
}
