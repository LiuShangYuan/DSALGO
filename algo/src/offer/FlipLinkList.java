package offer;
// 翻转链表
public class FlipLinkList {
    public ListNode ReverseList(ListNode head) {

        // 空或单节点
        if(head == null || head.next == null){
            return head;
        }
        // 空节点
        ListNode eHead = new ListNode(0);

        ListNode p = head;
        ListNode q = head.next;

        while (true){
            p.next = eHead.next;
            eHead.next = p;

            p = q;

            if(p == null){
                break;
            }
            q = q.next;
        }

        return eHead.next;
    }
}
