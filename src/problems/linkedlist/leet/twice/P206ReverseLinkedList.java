package problems.linkedlist.leet.twice;

public class P206ReverseLinkedList {

    public ListNode iterate(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

    public ListNode recurse(ListNode head) {
        // case1: empty list
        if (head == null) {
            return head;
        }
        // case2: only one element list
        if (head.next == null) {
            return head;
        }

        // case3: reverse from the rest after head
        ListNode newHead = recurse(head.next);
        // reverse between head and head.next
        head.next.next = head;
        // unlink list from the reverseList
        head.next = null;

        return newHead;        
    }

}
