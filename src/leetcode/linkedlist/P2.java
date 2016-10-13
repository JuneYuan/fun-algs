package leetcode.linkedlist;

//模拟加法运算
public class P2 {
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        
        int carry = 0;  //进位
        while (l1 != null || l2 != null || carry == 1) {
            int add = carry;
            if (l1 != null) {
                add += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                add += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(add % 10);
            p = p.next;
            
            carry = add / 10;
        }
        return dummyHead.next;
    }
}
