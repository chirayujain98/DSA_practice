package org.example.dynamic_programming;

import java.io.IOException;
import java.util.Scanner;

 class UVA00507 {
     public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int r = 1; r<=t; r++) {
            int s = sc.nextInt();
            int [] arr  = new int[s-1];
            for(int i = 0; i<s-1; i++) {
                arr[i] = sc.nextInt();
            }
            int curr = 1;
            int end = 1;
            int sum = 0;
            int maxSum = 0;
            int maxDiff = 0;
            int x = 0;
            int y = 0;
            boolean isValid = false;
            for(int i = 0; i<s-1; i++) {
                sum += arr[i];
                if(maxSum <= sum) {

                    if(maxSum == sum && (end-curr) <= maxDiff){
                        end++;
                        continue;
                    }
                    maxDiff = (end-curr);
                    maxSum = sum;
                    x = curr;
                    end = end+1;
                    y = end;

                    //System.out.println(x + " "+ y);
                    isValid = true;
                }
                else if(sum < 0){
                    sum = 0;
                    end = end+1;
                    curr = end;
                }else{
                    end++;
                }
                //System.out.println("s " + " " + i + " " + arr[i] + " " +  sum + " " + curr + " " + end);
            }
            if(!isValid) {
                System.out.println("Route "+ r +  " has no nice parts");
                continue;
            }

            System.out.println("The nicest part of route " + r + " is between stops " + (x) + " and " + (y));

        }
    }
}