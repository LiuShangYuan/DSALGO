package top_interview;
// 反转链表
public class ReverseLinkList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        int len = 0;

        ListNode i = head;
        while (i.next != null){
            len++;
            i = i.next;
        }
        // i指向为节点
        len++;

        k = k % len;

        ListNode j = head;
        int step = 0;
        while (j != null){
            step++;
            if(step == len - k){
                break;
            }
            j=j.next;
        }

        // 断开环 （注意完全旋转的情况）
        ListNode ret = j.next == null? head:j.next;
        j.next = null;
        if (ret != head) {
            i.next = head;
        }


        return ret;
    }
}
