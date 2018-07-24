package problems.linkedlist.leet.once;

public class P237DeleteNodeInLinkedList {

	// 反复地复制后继节点数据到当前节点，并删除该后继节点
    public void deleteNode_(ListNode node) {
        ListNode curr = node;
        while (curr.next != null) {
            curr.val = curr.next.val;
            // 检测是否到达最后节点，是则删除，结束
            if (curr.next.next == null) {
                curr.next = null;
                break;
            }
            
            curr = curr.next;
        }
    }

    // 复制后继节点数据到当前节点，直接删除后继节点（一次就够了……）
    public void deleteNode(ListNode node) {
        // unnecessary, the problem guarantees node wont be the tail
        if (node == null || node.next == null)  return;
        
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

}
