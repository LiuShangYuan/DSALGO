package hot100;

/**
 * 2. 两数相加
 * 两个数用链表表示, 直接计算数值相加再构建新链表会存在大数问题
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);

//        node1.next = node2;
//        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;

        ListNode newnode = new AddTwoNumbers().addTwoNumbers(node1, node4);

        System.out.println(newnode);

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        while (l1 != null && l2 != null) {
            int cur = l1.val + l2.val + jinwei;
            jinwei = cur / 10;
            cur = cur % 10;

            ListNode node = new ListNode(cur);
            ptr.next = node;
            ptr = node;

            l1 = l1.next;
            l2 = l2.next;
        }



        // TODO 可以搞一个指针指向l1和l2中非空的那个, 这样可以简化下面的代码
        if (l1 != null) {
            while (l1!=null) {
                int cur = l1.val + jinwei;
                jinwei = cur / 10;
                cur = cur % 10;
                ListNode node = new ListNode(cur);
                ptr.next = node;
                ptr = node;
                l1 = l1.next;
            }
        }

        if (l2 != null) {
            while (l2!=null) {
                int cur = l2.val + jinwei;
                jinwei = cur / 10;
                cur = cur % 10;
                ListNode node = new ListNode(cur);
                ptr.next = node;
                ptr = node;
                l2 = l2.next;
            }
        }

        if(jinwei!=0){
            ptr.next = new ListNode(jinwei);
        }

        if (head.next != null){
            return head.next;
        }

        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}