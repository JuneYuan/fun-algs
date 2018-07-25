package problems.linkedlist.leet.twice;

public class P82RmDupFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int preVal = p.next.val;
                while (p.next != null && p.next.val == preVal) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }

        return dummy.next;
    }

}
