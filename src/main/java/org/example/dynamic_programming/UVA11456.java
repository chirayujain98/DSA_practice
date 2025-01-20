package org.example.dynamic_programming;   

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UVA11456 {

    public static List<Integer> ans = new ArrayList<>();
    public static void helper(List<Integer> list) {
        if (list.isEmpty()) {
            ans.add(0);
            return;
        }
        
        List<Integer> train = new ArrayList<>();
        int maxLength = 0;
        
        // Try each car as the middle point
        for (int i = 0; i < list.size(); i++) {
            // Build increasing sequence to the left
            List<Integer> left = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j) < list.get(i)) {
                    left.add(list.get(j));
                }
            }
            
            // Build decreasing sequence to the right
            List<Integer> right = new ArrayList<>();
            right.add(list.get(i));
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < right.get(right.size() - 1)) {
                    right.add(list.get(j));
                }
            }
            
            maxLength = Math.max(maxLength, left.size() + right.size());
        }
        
        ans.add(maxLength);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }
            helper(list);
        }
        for(int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
    
}
