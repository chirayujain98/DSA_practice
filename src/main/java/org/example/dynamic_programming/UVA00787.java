package org.example.dynamic_programming;
import java.math.BigInteger;
import java.util.*;
public class UVA00787 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            ArrayList<BigInteger> arr = new ArrayList<>();
            for(int n = sc.nextInt(); n!=-999999; n = sc.nextInt()){
                arr.add(BigInteger.valueOf(n));
            }
            int l = arr.size();
            BigInteger maxValue = arr.get(0);
            for(int i = 0; i<l; i++){
                BigInteger product = arr.get(i);
                maxValue = maxValue.max(product);
                for(int j = i+1;j<l; j++){
                    product = product.multiply(arr.get(j));
                    maxValue = maxValue.max(product);
                }
            }
            System.out.println(maxValue);
        }
    }
}


// TLE solution with memoized DP
/*
public class UVA00787 {
    public static BigInteger res = BigInteger.valueOf(-999999999);
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            long[] numbers = Arrays.stream(line.split("\\s+")).mapToLong(Long::parseLong).toArray();
            Map<String, BigInteger> dp = new HashMap();
            BigInteger ans = recur(numbers, 0, BigInteger.ONE, dp);
            System.out.println(res);
            BigInteger answer = BigInteger.ONE;
            for(long v : numbers){
                if(v == -999999)
                    break;
                //System.out.println(v + " " + answer);
                answer = answer.multiply(BigInteger.valueOf(v));
            }
            //System.out.println("haha " + res  + " " + answer);

        }
        System.out.println(res);
    }
    public static BigInteger recur(long [] num, int i, BigInteger product, Map<String, BigInteger> dp) {
        if(num[i] == -999999){

            return product;
        }
        res = res.max(product);
        if(num[i] == 0){
            product = BigInteger.ONE;
            recur(num, i+1, product, dp);
        }
        String key = i + ":"  + product;
        if(dp.containsKey(key)) return dp.get(key);
        BigInteger a = recur(num, i+1, product.multiply(BigInteger.valueOf(num[i])), dp);
        BigInteger b = recur(num, i+1, BigInteger.valueOf(num[i]), dp);
        a = a.compareTo(b) > 0 ? a : b;
        dp.put(key,a);
        return a;
    }
}
*/
