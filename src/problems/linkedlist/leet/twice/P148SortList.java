package problems.linkedlist.leet.twice;

public class P148SortList {

    /**
     * 归并排序（根据链表长度求中间节点）
     */
    public ListNode solution1(ListNode head) {
        if (head == null) {
            return null;
        }

        // get the length of List
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        return sortListHelper(head, len);
    }

    private ListNode sortListHelper(ListNode head, final int length) {
        if (head == null || length == 0) {
            return head;
        }

        ListNode midNode = head;
        int cnt = 1;
        while (cnt < length/2) {
            midNode = midNode.next;
            cnt++;
        }

        ListNode listR = sortListHelper(midNode.next, length - length/2);
        midNode.next = null;
        ListNode listL = sortListHelper(head, length/2);

        return merge1(listL, listR);
    }

    private ListNode merge1(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }

            p = p.next;
        }

        p.next = (head1 != null) ? head1 : head2;

        return dummy.next;
    }


    /**
     * 归并排序（快慢指针求中间节点）
     */
    public ListNode solution2(ListNode head) {
        // 退出条件：0个节点或1个节点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode left = head, right = mid.next;
        mid.next = null;
        left = solution2(left);
        right = solution2(right);

        return merge2(left, right);
    }

    private ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge2(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (head1 != null || head2 != null) {
            int a = (head1 == null) ? Integer.MAX_VALUE : head1.val;
            int b = (head2 == null) ? Integer.MAX_VALUE : head2.val;
            if (a < b) {
                p.next = new ListNode(a);
                if (head1 != null) {
                    head1 = head1.next;
                }
            } else {
                p.next = new ListNode(b);
                if (head2 != null) {
                    head2 = head2.next;
                }
            }

            p = p.next;
        }

        return dummy.next;
    }


    /**
     * 归并排序（自底向上）
     */
    public ListNode solution3(ListNode head) {
        return null;
    }

}
