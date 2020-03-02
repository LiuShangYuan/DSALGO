package offeragain;
// 反转链表
public class ReverseLinkList {

    // 1) 递归
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);


        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // 2) 头插法
    public ListNode reverseList_v2(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode tmp = new ListNode(0);
        ListNode p = head;
        while (p!=null){
            ListNode q = p.next;
            p.next = tmp.next;
            tmp.next = p;
            p = q;
        }


        return tmp.next;
    }

    // 3) 双指针
    public ListNode reverseList_v3(ListNode head) {
        ListNode p = null;
        ListNode q = head;


        while (q != null){
            ListNode tmp = q.next;

            q.next = p;

            p = q;
            q = tmp;
        }

        return p;
    }


}
