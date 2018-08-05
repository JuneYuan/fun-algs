package problems.linkedlist.lint;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
