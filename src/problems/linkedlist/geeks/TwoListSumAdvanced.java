package problems.linkedlist.geeks;

public class TwoListSumAdvanced {

    public ListNode solve(ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode tmpSum = add(head1, head2);
        return reverse(tmpSum);
    }

    private ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode prev = null, succ = null;
        while (p != null) {
            succ = p.next;
            p.next = prev;
            prev = p;
            p = succ;
        }

        return p;
    }

    private ListNode add(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);

        ListNode p = dummy;
        int sum = 0, carry = 0;
        while (head1 != null || head2 != null || carry > 0) {
            int valL = 0, valR = 0;
            if (head1 != null) {
                valL = head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                valR = head2.val;
                head2 = head2.next;
            }
            sum = valL + valR + carry;
            p.next = new ListNode(sum % 10);

            carry = sum / 10;
            p = p.next;
        }

        return dummy.next;
    }

}
