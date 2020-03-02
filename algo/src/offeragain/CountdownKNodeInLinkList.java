package offeragain;

import org.junit.Test;

// 链表中的倒数第k个节点
public class CountdownKNodeInLinkList {
    /**
     * 一个指针先走k步
     * 另一个指针从开始和第一个指针一起走，第一个指针到尾部的时候，第二个指针就是倒数第k个
     *
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode p = head;
        // 是不是break出来的
        boolean flag = false;

        int step = 0;
        while (p!=null){
            step++;
            p=p.next;
            if (step == k){
                flag = true;
                break;
            }
        }

        if (!flag)
            return null;


        ListNode q = head;

        while (p!=null){
            p = p.next;
            q = q.next;
        }

        return q;

    }


    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        getKthFromEnd(node1, 2);
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
