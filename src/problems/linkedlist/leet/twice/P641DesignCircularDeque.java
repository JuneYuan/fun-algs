package problems.linkedlist.leet.twice;

public class P641DesignCircularDeque {

    Node first, last;
    private int size = 0;
    private int capacity;

    private static class Node {
        int value;
        Node prev, next;

        Node(Node prev, int value, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public P641DesignCircularDeque(int k) {
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull())   return false;

        Node f = first;
        Node newNode = new Node(null, value, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull())   return false;

        Node l = last;
        Node newNode = new Node(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;

        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        Node f = first;
        if (f == null)  return false;

        int val = f.value;
        Node next = f.next;
        // f.value = -1;
        f.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;

        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        Node l = last;
        if (l == null)  return false;

        int val = l.value;
        final Node prev = l.prev;
        // l.value = -1;
        l.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;

        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        Node f = first;
        if (f == null)  return -1;
        return f.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        Node l = last;
        if (l == null)  return -1;
        return l.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

}
