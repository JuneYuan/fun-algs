package leetcode.linkedlist;

public class P21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}		
		// link to non-null list
		curr.next = (l1 != null) ? l1 : l2;
		
		return dummy.next;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
	
	@Override
	public String toString() {
		return Integer.toString(val);
	}
}