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
        int sum = 0;
        while (l1!=null || l2!=null || carry==1) {
            sum += carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            p = p.next;
            
            carry = sum / 10;
            sum = 0;
        }
        return dummyHead.next;
    }
}
