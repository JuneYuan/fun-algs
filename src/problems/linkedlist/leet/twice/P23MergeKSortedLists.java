package problems.linkedlist.leet.twice;

public class P23MergeKSortedLists {

    /**
     * 从k个链表中选择最小的节点链接到lastNode->next (和选择排序的思路有点类似)，同时该节点所在的链表表头节点向后递推一个。
     */
    public ListNode solution1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (true) {
            int count = 0;
            int index = -1, tmpVal = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    count++;
                    if (count == lists.length) {
                        p.next = null;
                        return dummy.next;
                    }
                    continue;
                }

                if (lists[i] != null && lists[i].val <= tmpVal) {
                    tmpVal = lists[i].val;
                    index = i;
                }
            }

            p.next = lists[index];
            p = p.next;
            lists[index] = lists[index].next;
        }
    }

    public ListNode mySolution(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

//        while (true) { // todo 循环条件
//            ;
//        }
        return null;
    }


}
