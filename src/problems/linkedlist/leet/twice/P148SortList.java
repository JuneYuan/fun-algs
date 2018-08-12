package problems.linkedlist.leet.twice;

public class P148SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        // get the length of List
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        return sortListHelper(head, len);
    }

    private ListNode sortListHelper(ListNode head, final int length) {
        if (head == null || length == 0) {
            return head;
        }

        ListNode midNode = head;
        int cnt = 1;
        while (cnt < length/2) {
            midNode = midNode.next;
            cnt++;
        }

        ListNode listR = sortListHelper(midNode.next, length - length/2);
        midNode.next = null;
        ListNode listL = sortListHelper(head, length/2);

        return mergeList(listL, listR);
    }

    private ListNode mergeList(ListNode listL, ListNode listR) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        while (listL != null && listR != null) {
            if (listL.val < listR.val) {
                lastNode.next = listL;
                listL = listL.next;
            } else {
                lastNode.next = listR;
                listR = listR.next;
            }

            lastNode = lastNode.next;
        }

        lastNode.next = (listL != null) ? listL : listR;

        return dummy.next;
    }

}
