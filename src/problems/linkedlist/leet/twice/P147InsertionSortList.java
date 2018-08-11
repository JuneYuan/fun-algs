package problems.linkedlist.leet.twice;

public class P147InsertionSortList {

    public ListNode solution1(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode pre = dummy;
            while (pre.next != null && pre.next.val < p.val) {
                pre = pre.next;
            }
            ListNode tmp = p.next;
            p.next = pre.next;
            pre.next = p;

            p = tmp;
        }

        return dummy.next;
    }

    public ListNode solution2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        while (p != null) {
            if (p.next != null && p.next.val < p.val) {
                // find insert position for smaller (p.next)
                ListNode pre = dummy;
                while (pre.next != null && pre.next.val < p.next.val) {
                    pre = pre.next;
                }
                // insert p.next after pre
                ListNode tmp = p.next.next;
                p.next.next = pre.next;
                pre.next = p.next;

                p.next = tmp;
            } else {
                p = p.next;
            }
        }

        return dummy.next;
    }

}
