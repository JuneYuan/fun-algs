package problems.linkedlist.leet.twice;

public class P206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        List prev = null, curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

}
