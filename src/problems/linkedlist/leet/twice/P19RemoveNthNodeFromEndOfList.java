package problems.linkedlist.leet.twice;

public class P19RemoveNthNodeFromEndOfList {

    /**
     * 思路：删除倒数第n个节点，相当于删除正数第(len - n + 1)个节点
     * 不足：需要遍历整个链表求len
     */
    public ListNode mySolution(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int len = getLength(head), i = 0;
        ListNode p = dummy;
        while (i < len - n) {
            p = p.next;
            i++;
        }

        p.next = p.next.next;

        return dummy.next;
    }

    private int getLength(ListNode head) {
        int len = 0;

        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }

        return len;
    }


    /**
     * 快慢指针
     */
    public ListNode solution1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }

}
