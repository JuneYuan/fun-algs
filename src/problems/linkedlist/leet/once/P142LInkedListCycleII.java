package leetcode1st.linkedlist;

public class P142LInkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // find Collision Spot
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        
        // check if there is a cycle
        if (fast == null || fast.next == null) {
            return null;
        }
        
        // move slow to head, and fast remains, so that they are at the same distance to cycle-start-node
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }

}
