package problems.linkedlist.leet.twice;

import java.util.ArrayDeque;
import java.util.Deque;

public class P234PalindromeLinkedList {

    public boolean mySolution(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // find mid
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode join = slow;

        // revert right half
        join.next = revert(slow.next);

        // judge palindrome
        ListNode p1 = head, p2 = join.next;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // recover right half
        join.next = revert(slow.next);

        return true;
    }

    private ListNode revert(ListNode head) {
        ListNode p = head, prev = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;
        }
        return prev;
    }

    /**
     * 使用辅助栈
     */
    public boolean solution1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        // find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // skip mid node if the number of ListNode is odd
        if (fast != null) {
            slow = slow.next;
        }

        ListNode rCurr = slow;
        while (rCurr != null) {
            if (rCurr.val != stack.pop()) {
                return false;
            }
            rCurr = rCurr.next;
        }

        return true;
    }

    /**
     * 原地翻转
     */
    public boolean solution2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // find mid
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // skip mid node if the number of ListNode is odd
        if (fast != null) {
            slow = slow.next;
        }

        // reverse right part of List
        ListNode rHead = revert(slow);
        ListNode lCurr = head, rCurr = rHead;
        while (rCurr != null) {
            if (rCurr.val != lCurr.val) {
                revert(rHead);
                return false;
            }
            lCurr = lCurr.next;
            rCurr = rCurr.next;
        }
        // recover right part of List
        revert(rHead);

        return true;
    }

}
