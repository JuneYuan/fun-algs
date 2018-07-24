package problems.linkedlist.leet.once;

public class P82RemoveDuplidatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)   return null;
        
        // 引入dummy node来处理链表头节点不确定的问题
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        
        /* curr迭代访问整个链表，
         * 若下一节点值存在重复，就逐个删掉所有重复元素，
         * 删除过程，借助`runner`指针来完成；
         * 否则继续遍历
         */
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                ListNode runner = curr.next;
                int dupVal = runner.val;
                while (runner != null && runner.val == dupVal) {
                    curr.next = runner.next;    // 删除重复元素
                    runner = runner.next;       // 移动runner
                }
            } else {
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}
