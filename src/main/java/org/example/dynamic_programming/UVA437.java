package org.example.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class UVA437 {

    static class Item {
        int a;
        int b;
        int c;
         Item(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static int LISvalue(ArrayList<Item> list) {
        int n = list.size();
        int[] dp = new int[n];
        Collections.sort(list, (a, b) -> a.a - b.a);
        for(int i = 0; i < n; i++) {
            dp[i] = list.get(i).c;
        }
        int maxHeight = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(list.get(i).a > list.get(j).a && list.get(i).b > list.get(j).b) {
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).c);
                    maxHeight = Math.max(maxHeight, dp[i]);
                }
            }
        }
        return maxHeight;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int r = 1;
        while(t != 0) {
            ArrayList<Item> list = new ArrayList<>();
            for(int i = 0; i < t; i++) {
                String line = sc.nextLine();
                String [] arr = line.trim().split("\\s+");
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                int c = Integer.parseInt(arr[2]);
                list.add(new Item(a, b, c));
                list.add(new Item(b, a, c));
                list.add(new Item(c, a, b));
                list.add(new Item(c, b, a));
                list.add(new Item(b, c, a));
                list.add(new Item(a, c, b));
            }
            System.out.println("Case " + r + ": maximum height = " + LISvalue(list));
            r++;
            t = sc.nextInt();
            sc.nextLine();
        }
        sc.close();
    }
}
