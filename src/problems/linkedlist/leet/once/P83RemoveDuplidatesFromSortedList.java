package leetcode1st.linkedlist;

// Remove Duplicates from Sorted List
public class P83RemoveDuplidatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)   return null;
        
        ListNode curr = head;
        while (curr != null) {  // curr迭代访问整个链表
            ListNode runner = curr;
            while (runner.next != null && runner.next.val == curr.val) {  // runner移除后续所有与curr重复的
                runner.next = runner.next.next;  // 每次更新的是runner.next
            }
            
            curr = curr.next;
        }
        
        return head;
    }
}
