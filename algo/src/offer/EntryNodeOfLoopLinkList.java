package offer;

// 链表中环的入口结点
public class EntryNodeOfLoopLinkList {

    // 快慢指针

    // 相遇之后

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;


        while (slow != null && fast != null) {
            slow = slow.next;

            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
            }

            // 相遇
            if (slow == fast && slow != null) {
                ListNode start = pHead;
                ListNode meet = slow;

                while (start != null && meet != null) {
                    if (start == meet) {
                        return start;
                    }
                    start = start.next;
                    meet = meet.next;
                }
            }
        }

        return null;
    }
}
