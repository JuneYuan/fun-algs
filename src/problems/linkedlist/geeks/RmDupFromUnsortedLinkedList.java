package problems.linkedlist.geeks;

public class RmDupFromUnsortedLinkedList {

    public static ListNode twoLoopSolution(ListNode head) {
        ListNode p = head;
        while (p != null) {
            ListNode q = p;
            while (q.next != null) {
                if (q.next.val == p.val) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }

            p = p.next;
        }

        return head;
    }

    public static ListNode hashtableSolution(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        HashMap<Integer, Boolean> hash = new HashMap<>();
        hash.put(p.val, true);
        while (p.next != null) {
            if (hash.containsKey(p.next.val)) {
                p.next = p.next.next;
            } else {
                hash.put(curr.next.val, true);
                p = p.next;
            }
        }

        return head;
    }

}
