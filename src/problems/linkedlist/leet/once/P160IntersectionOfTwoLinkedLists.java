package leetcode1st.linkedlist;

// 两条单链表相交求交点
public class P160IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // no intersection
        if (headA == null || headB == null)  return null;
        
        // align
        int len1 = length(headA);
        int len2 = length(headB);
        for (int i = 0; i < len1 - len2; i++)   headA = headA.next;
        for (int i = 0; i < len2 - len1; i++)   headB = headB.next;
        
        // try to find interseciton node
        // exit when (at least) one list comes to an end, OR intersection node is found
        while (headA != headB && headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }
        
        if (headA == null || headB == null)  return null;
        return headA;
    }
    
    private int length(ListNode head) {
        // if (head == null)   return 0;  // unnecessary here
        
        int cnt = 0;
        while (head.next != null) {
            cnt++;
            head = head.next;
        }
        
        return cnt;
    }

}
