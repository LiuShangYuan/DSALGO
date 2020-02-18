package offer;

/**
 * 合并两个排序的链表
 */
public class MergeSortedLinkList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode p = list1;
        ListNode q = list2;

        ListNode head = new ListNode(0);
        ListNode np = head;

        while (p != null && q != null) {
            if(p.val < q.val){
                np.next = p;
                p = p.next;
            }else {
                np.next = q;
                q = q.next;
            }
            np = np.next;
        }

        while (p!=null){
            np.next = p;
            p = p.next;
            np = np.next;
        }

        while (q!=null){
            np.next = q;
            q = q.next;
            np = np.next;
        }


        return head.next;
    }
}
