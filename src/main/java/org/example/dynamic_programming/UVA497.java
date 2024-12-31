package org.example.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UVA497 {
    //TODO: While submitting getting TLE. Need to optimize.
    public static void LIS(List<Integer> list) {
        int n = list.size();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int maxLength = 0;
        int index = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(list.get(i) > list.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] > maxLength) {
                        maxLength = dp[i];
                        index = i;
                    }
                }
            }
        }
        System.out.println("Max hits: "+ maxLength);
        int r = index;
        int element = list.get(index);
        List<Integer> result = new ArrayList<>();
        result.add(element);
        
        maxLength--;
        while(maxLength!=0) {
            for(int j = 0; j < r; j++) {
                if(list.get(j) < element && dp[j] == maxLength) {
                    element = list.get(j);
                    result.add(element);
                    r=j;
                    maxLength--;
                    break;
                }
            }
        }
        Collections.reverse(result);
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        System.out.println();
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
            LIS(list);
        }
        sc.close();
    }
}
