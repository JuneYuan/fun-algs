package problems.linkedlist.lint;

public class P174RemoveNthNodeFromEndOfList {

    /**
     * "删除倒数第n个"，转化为"删除第（len - n + 1）"个
     */
    public ListNode solution1(ListNode head, int n) {
        // first, calculate length of the linked list
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        // remove nth from the end is equivalent to remove (len - n)th from the start
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        p = dummy;
        for (int i = 0; i < len - n; i++) {
            p = p.next;
        }

        if (p.next != null) {
            p.next = p.next.next;
        }

        return p == dummy ? p.next : dummy.next;
    }

    /**
     * 快慢指针
     */
    public ListNode solution2(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preDel = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            preDel = preDel.next;
        }
        preDel.next = preDel.next.next;

        return dummy.next;
    }

}
