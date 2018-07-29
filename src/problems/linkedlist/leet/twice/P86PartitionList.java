package problems.linkedlist.leet.twice;

public class P86PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(0), pL = dummyL;
        ListNode dummyR = new ListNode(0), pR = dummyR;

        ListNode runner = head;
        while (runner != null) {
            if (runner.val < x) {
                pL.next = runner;
                pL = pL.next;
            } else {
                pR.next = runner;
                pR = pR.next;
            }
            runner = runner.next;
        }

        // cur off ListNode after pR to avoid cycle
        pR.next = null;
        pL.next = dummyR.next;

        return dummyL.next;
    }
}
