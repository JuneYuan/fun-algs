package problems.linkedlist.leet.twice;

public class P2AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);

        ListNode p = dummy;
        int acc = 0, sum = 0;
        while (node1 != null || node2 != null || acc != 0) {
            int digitL = 0, digitR = 0;
            if (node1 != null) {
                digitL = node1.val;
                node1 = node1.next;
            }
            if (node2 != null) {
                digitR = node2.val;
                node2 = node2.next;
            }
            sum = digitL + digitR + acc;
            p.next = new ListNode(sum % 10);

            acc = sum < 10 ? 0 : 1;
            p = p.next;
        }

        return dummy.next;
    }

}
