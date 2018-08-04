package problems.linkedlist.leet.twice;

public class P2AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);

        ListNode p = dummy;
        int carry = 0, sum = 0;
        while (node1 != null || node2 != null || carry != 0) {
            int digitL = 0, digitR = 0;
            if (node1 != null) {
                digitL = node1.val;
                node1 = node1.next;
            }
            if (node2 != null) {
                digitR = node2.val;
                node2 = node2.next;
            }
            sum = digitL + digitR + carry;
            p.next = new ListNode(sum % 10);

            carry = sum / 10;
            p = p.next;
        }

        return dummy.next;
    }

}
