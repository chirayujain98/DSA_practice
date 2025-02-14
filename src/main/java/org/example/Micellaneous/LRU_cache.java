package org.example.Micellaneous;

import java.util.HashMap;
import java.util.Map;

class Node {
    Node prev, next;
    String value;
    Node(String value) {
        this.value = value;
    }
}
public class LRU_cache {

    static Map<String, Node> mp = new HashMap<>();
    static Node head = new Node("0");
    static Node tail = new Node("0");
    
    public static void lruCahce(String [] arr) {
        head.next = tail;
        tail.prev = head;
        for(String s : arr) {
            if(mp.containsKey(s)) {
                update(s);
            }else{
                if(mp.size() == 5){
                    remove();
                }
                insert(new Node(s));
            }
        }

        Node temp = head.next;
        while(temp!=tail) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        
    }

    public static void remove() {
        if(tail == head) return;
        Node lastNode = tail.prev;
        mp.remove(lastNode.value);
        lastNode.prev.next = tail;
        tail.prev = lastNode.prev;
    }
    public static void update(String s) {
        if(mp.containsKey(s)) {
            Node node = mp.get(s);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            insert(node);
        }else{
        if(mp.size() == 5) {
            remove();
        }
        insert(new Node(s));
        }
    }
    public static void insert(Node node) {
        mp.put(node.value, node);
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;

    }  
    public static void main(String [] args) {
        String [] arr =  {"A", "B", "D", "A", "E", "C", "G", "D"};
        lruCahce(arr);
    }
}
