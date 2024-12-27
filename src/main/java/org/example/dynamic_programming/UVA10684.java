package org.example.dynamic_programming;

import java.util.ArrayList;
import java.util.Scanner;

// A Kadane's algorithm varient

public class UVA10684 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int l = sc.nextInt();
            if(l == 0) break;
            ArrayList<Integer> arr = new ArrayList<>();
            while(l > 0){
                arr.add(sc.nextInt());
                l--;
            }
            long curr = 0;
            long max = Long.MIN_VALUE;
            for(int  i =0; i<arr.size(); i++) {
                curr += arr.get(i);
                max = Math.max(max, curr);
                if(curr < 0){
                    curr = 0;
                }
            }
            if(max <= 0){
                System.out.println("Losing streak.");
            }else {
                System.out.println("The maximum winning streak is " + max + ".");
            }
        }
    }

}
