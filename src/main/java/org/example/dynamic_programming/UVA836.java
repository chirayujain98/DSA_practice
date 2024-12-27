package org.example.dynamic_programming;

import java.util.*;

public class UVA836 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            List<List<Integer>> arr = new ArrayList<>();
            sc.nextLine();
            int n = 1;
            for(int i = 0; i<n; i++) {
                String str = sc.nextLine();
                n = str.length();
                if (str.isEmpty()) break;
                char[] input = str.toCharArray();
                List<Integer> temp = new ArrayList<>();
                for (char s : input) {
                    int val = Character.getNumericValue(s);
                    if (val == 0) {
                        temp.add(-127*100*100);
                    } else {
                        temp.add(val);
                    }
                }
                arr.add(new ArrayList<>(temp));
            }
            //if (sc.hasNextLine()) sc.nextLine();
            int [][] dp = new int[arr.size()][arr.get(0).size()];

            for(int i = 0; i<arr.size(); i++) {
                for(int j = 0; j<arr.get(0).size(); j++) {
                    dp[i][j] = arr.get(i).get(j);
                    //System.out.print(dp[i][j] + " ");
                }
                //System.out.println("");
            }
            // logic to get the maximum sum
            for(int i = 0; i<arr.size(); i++) {
                for(int j = 0; j<arr.get(0).size(); j++) {
                    if(i > 0) dp[i][j] += dp[i-1][j];
                    if(j > 0) dp[i][j] += dp[i][j-1];
                    if(i > 0 && j > 0) dp[i][j] -= dp[i-1][j-1];
                }
            }

            int res = Integer.MIN_VALUE;
            for(int i = 0; i<arr.size(); i++) {
                for(int i1 = i; i1<arr.size(); i1++) {
                    int val = 0;
                    for(int j = 0; j<arr.get(0).size(); j++) {
                        int curr = dp[i1][j];
                        if (i > 0) curr -= dp[i - 1][j];
                        if (j > 0) curr -= dp[i1][j - 1];
                        if (i > 0 && j > 0) curr += dp[i - 1][j - 1];
                        val += curr;
                        res = Math.max(res, val);
                        if(val < 0) val = 0;
                    }
                }
            }
            if(res == -127*100*100)System.out.println("0");
            else System.out.println(res);
            if(t!=0) System.out.println("");
        }
    }
}
