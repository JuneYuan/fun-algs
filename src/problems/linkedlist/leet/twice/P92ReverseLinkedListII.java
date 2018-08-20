package problems.linkedlist.leet.twice;

public class P92ReverseLinkedListII {

    public ListNode mySolution(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // find the join node
        ListNode joinNode = dummy;
        for (int i = 0; i < m - 1; i++) {
            joinNode = joinNode.next;
        }

        ListNode prev = joinNode.next, p = prev.next;
        for (int i = 0; i < n - m; i++) {
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;
        }

        joinNode.next.next = p;
        joinNode.next = prev;

        return dummy.next;
    }

    public ListNode billryanSolution(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // find the mth node
        ListNode premNode = dummy;
        for (int i = 1; i < m; i++) {
            premNode = premNode.next;
        }

        // reverse node between m and n
        ListNode prev = null, p = premNode.next;
        while (p != null && (m <= n)) {
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;
            m++;
        }

        // join head and tail before m and after n
        premNode.next.next = p;
        premNode.next = prev;

        return dummy.next;
    }

}
