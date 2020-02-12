package offer;

import org.junit.Test;

// 删除链表中的重复节点
public class RemoveDuplicateNodeOfLinkList {

    // before、after两个指针
    // 一个bool变量知识 before指向的值是否是之前重复过的
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }

        ListNode before, after;
        boolean bd = false;
        ListNode head = new ListNode(0); // 头结点
        ListNode point = head;

        before = pHead;
        after = pHead.next;

        while (before != null) {
            if (bd == false) {
                if (after == null || before.val != after.val) {
                    // link
                    point.next = before;
                    point = point.next;
                }
                if (after != null && before.val == after.val) {
                    // change bd
                    bd = true;
                }
            } else { // bd = true
                if (after != null && before.val != after.val) {
                    bd = false;
                }
            }

            before = after;

            if (after != null) {
                after = after.next;
            }
            // 置空, 不然还会连接着原来的链表数据
            point.next = null;
        }

        return head.next;

    }


    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;


        ListNode head = deleteDuplication(node1);

        System.out.println();
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}