package problems.linkedlist.leet.twice;

public class P83RmDupFromSortedList {

    public ListNode originalSolution(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode p = head;
        while (p != null && p.next != null) {
            while (p.next != null && p.next.val == p.val) {
                p.next = p.next.next;
            }

            p = p.next;
        }

        return head;
    }

    public ListNode refinedSolution(ListNode head) {
        ListNode p = head;
        while (p != null) {
            while (p.next != null && p.next.val == p.val) {
                p.next = p.next.next;
            }
            p = p.next;
        }

        return head;
    }

}
