package hot100;

/**
 * 19 删除链表的倒数第N个节点
 */
public class RemoveNthFromEndOfLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode header = new RemoveNthFromEndOfLinkedList().removeNthFromEnd(node1, 5);

        System.out.println("xxx");
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode ptr1 = head;
        ListNode ptr2 = head;

        int count = 0;
        while (ptr1 != null) {
            if (count >= n) {
                break;
            }
            ptr1 = ptr1.next;
            count++;
        }

        // 删除的是第一个节点
        if (ptr1 == null && count == n) {
            return head.next;
        }

        while (ptr1 != null && ptr1.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        if (ptr1 != null && ptr1.next == null) {
            ptr2.next = ptr2.next.next;
        }


        return head;
    }
}
