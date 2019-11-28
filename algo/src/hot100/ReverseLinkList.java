package hot100;

/**
 * User: yinkai
 * Date: 2019-11-28
 * Time: 21:31
 */

// 206. 反转链表
public class ReverseLinkList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode newhead = new ReverseLinkList().reverseList(head);

        System.out.println();
    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }


        ListNode fake = new ListNode(0);

        while (head != null){
            ListNode p = head;
            head = head.next;
            p.next = fake.next;
            fake.next = p;

        }

        return fake.next;
    }
}


//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}