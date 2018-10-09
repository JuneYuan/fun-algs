package problems.binarysearchtree.leet.twice;

public class P109ConvetSortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)   return null;

        // get the size of list
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }

        return buildBSTHelper(head, len);
    }

    private TreeNode buildBSTHelper(ListNode head, int length) {
        if (head == null || length < 1) {
            return null;
        }

        // get the middle ListNode as root TreeNode
        ListNode lNode = head;
        int cnt = 0;
        while (cnt < length/2) {
            lNode = lNode.next;
            cnt++;
        }

        TreeNode root = new TreeNode(lNode.val);
        root.left = buildBSTHelper(head, length/2);
        root.right = buildBSTHelper(lNode.next, length - 1 - length/2);

        return root;
    }

}

class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)   return null;
        return helper(head);
    }

    private TreeNode helper(ListNode head) {
        if (head == null)   return null;
        if (head.next == null)  return new TreeNode(head.val);

        ListNode pre = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        TreeNode root = new TreeNode(slow.val);
        TreeNode L = helper(head);
        TreeNode R = helper(slow.next);
        root.left = L;
        root.right = R;

        return root;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}