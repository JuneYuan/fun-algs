package problems.linkedlist.leet.twice;

import java.util.HashMap;

public class P146LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap <>();
    private Node dummyHead = new Node(-1, -1);
    private Node dummyTail = new Node(-1, -1);

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

    public P146LRUCache(int capacity) {
        this.capacity = capacity;
        dummyTail.prev = dummyHead;
        dummyHead.next = dummyTail;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // remove current
        Node currNode = map.get(key);
        currNode.prev.next = currNode.next;
        currNode.next.prev = currNode.prev;

        // move curr to tail
        moveToTail(currNode);

        return map.get(key).val;
    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }

        if (map.size() == capacity) {
            map.remove(dummyHead.next.key);
            dummyHead.next = dummyHead.next.next;
            dummyHead.next.prev = dummyHead;
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }

    private void moveToTail(Node curr) {
        curr.prev = dummyTail.prev;
        dummyTail.prev = curr;
        curr.prev.next = curr;
        curr.next = dummyTail;
    }

}
