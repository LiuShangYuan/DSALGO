package offeragain;

public class DeleteLinkListNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode p = null;
        ListNode q = head;

        while (q!=null){
            if (q.val == val){
                if (p == null){
                    return q.next;
                }else {
                    p.next = q.next;
                    return head;
                }
            }

            p = q;
            q = q.next;
        }

        return null;
    }
}
