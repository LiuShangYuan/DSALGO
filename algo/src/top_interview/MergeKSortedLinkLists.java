package top_interview;

import org.junit.Test;

/**
 * User: yinkai
 * Date: 2019-11-30
 * Time: 15:42
 */
public class MergeKSortedLinkLists {


    @Test
    public void test() {

        ListNode lnode1 = new ListNode(1);
        ListNode lnode2 = new ListNode(4);
        ListNode lnode3 = new ListNode(5);

        lnode1.next = lnode2;
        lnode2.next = lnode3;

        ListNode lnode4 = new ListNode(1);
        ListNode lnode5 = new ListNode(3);
        ListNode lnode6 = new ListNode(4);

        lnode4.next = lnode5;
        lnode5.next = lnode6;


        ListNode lnode7 = new ListNode(2);
        ListNode lnode8 = new ListNode(6);

        lnode7.next = lnode8;

//        ListNode node = mergeKLists(new ListNode[]{lnode1, lnode4, lnode7}, 0, 2);
        ListNode node = mergeKLists(new ListNode[]{});
        System.out.println();
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }


    // 分治
    public ListNode mergeKLists(ListNode[] lists, int left, int right) {

        if (left == right) {
            return lists[left];
        }

        int mid = (left + right) / 2;
        ListNode leftLists = mergeKLists(lists, left, mid);
        ListNode rightLists = mergeKLists(lists, mid + 1, right);

        return merge2Lists(leftLists, rightLists);

    }


    private ListNode merge2Lists(ListNode leftLists, ListNode rightLists) {
        ListNode p1 = leftLists;
        ListNode p2 = rightLists;

        ListNode head = new ListNode(0); //头结点
        ListNode tail = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }


        ListNode left = (p1 == null) ? p2 : p1;
        while (left != null) {
            tail.next = left;
            tail = left;
            left = left.next;
        }

        return head.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}