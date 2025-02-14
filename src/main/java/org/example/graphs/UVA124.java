package org.example.graphs;

import java.util.*;

public class UVA124 {
    private static List<List<Integer>> adj;
    private static boolean[] used;
    private static List<String> result;
    private static char[] variables;
    private static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean first = true;
        
        while(sc.hasNextLine()) {
            try {
                if(!first) {
                    System.out.println();
                }
                first = false;
                
                // Read variables
                String vars = sc.nextLine().trim();
                String[] varArray = vars.split("\\s+");
                n = varArray.length;
                variables = new char[n];
                for(int i = 0; i < n; i++) {
                    variables[i] = varArray[i].charAt(0);
                }
                Arrays.sort(variables);  // Sort to ensure lexicographical order
                
                // Initialize graph
                adj = new ArrayList<>();
                for(int i = 0; i < 26; i++) {
                    adj.add(new ArrayList<>());
                }
                
                // Read constraints
                String constraints = sc.nextLine().trim();
                if(!constraints.isEmpty()) {
                    String[] constArray = constraints.split("\\s+");
                    for(int i = 0; i < constArray.length; i += 2) {
                        char x = constArray[i].charAt(0);
                        char y = constArray[i+1].charAt(0);
                        createGraph(x, y);
                    }
                }
                
                // Generate all possible orders
                result = new ArrayList<>();
                used = new boolean[26];
                StringBuilder current = new StringBuilder();
                
                generateOrders(current);
                
                // Print results in lexicographical order
                Collections.sort(result);
                for(String order : result) {
                    System.out.println(order);
                }
                
                // Skip blank line between test cases
                if(sc.hasNextLine()) {
                    sc.nextLine();
                }
                
            } catch(Exception e) {
                break;
            }
        }
    }
    
    private static void generateOrders(StringBuilder current) {
        if(current.length() == n) {
            result.add(current.toString());
            return;
        }
        
        for(int i = 0; i < n; i++) {
            char var = variables[i];
            int idx = var - 'a';
            
            if(!used[idx] && canUse(idx, used)) {
                used[idx] = true;
                current.append(var);
                generateOrders(current);
                current.setLength(current.length() - 1);
                used[idx] = false;
            }
        }
    }
    
    private static boolean canUse(int var, boolean[] used) {
        // Check if all prerequisites are used
        for(int i = 0; i < 26; i++) {
            if(adj.get(i).contains(var) && !used[i]) {
                return false;
            }
        }
        return true;
    }
    
    private static void createGraph(char x, char y) {
        // x must come before y
        adj.get(x - 'a').add(y - 'a');
    }
}
