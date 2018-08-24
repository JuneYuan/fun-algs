package problems.linkedlist.leet.twice;

public class P24SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;

        ListNode left = head, right = null, join = null;
        while (left != null) {
            right = left.next;
            if (right != null) {
                ListNode tmp = right.next;
                right.next = left;
                left.next = null;
                if (join != null) {
                    join.next = right;
                }
                join = left;
                left = tmp;
            } else {
                join.next = left;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[3];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(i + 1);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }

        new P24SwapNodesInPairs().swapPairs(nodes[0]);
    }

}
