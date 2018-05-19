package leetcode1st.linkedlist;

import java.util.HashMap;

// LRU 算法
public class P146 {
	private int capacity;
	private HashMap<Integer, Node> map = new HashMap<>();
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);
	
	private class Node {
		Node prev, next;
		int val, key;
		
		public Node(int key, int val) {
			this.val = val;
			this.key = key;
			prev = null;
			next = null;
		}
	}
    
    public P146(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
        	return -1;
        }
        // remove current
        Node curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        // move curr to tail
        moveToTail(curr);
        
        return map.get(key).val;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
        	map.get(key).val = value;
        	return;
        }
        
        if (map.size() == capacity) {
        	map.remove(head.next.key);
        	head.next = head.next.next;
        	head.next.prev = head;
        }
        
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }
    
    private void moveToTail(Node curr) {
    	curr.prev = tail.prev;
    	curr.prev.next = curr;
    	tail.prev = curr;
    	curr.next = tail;
    }
}
