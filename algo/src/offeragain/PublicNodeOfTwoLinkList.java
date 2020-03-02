package offeragain;
// 两个链表的第一个公共节点
public class PublicNodeOfTwoLinkList {
    /**
     * 1) 分别计算出两个链表的长度
     * 2) 长的链表先走长度差步
     * 3) 两个链表同时遍历
     *
     *
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLength(headA);
        int len2 = getLength(headB);

        if (len1 > len2){
            // headA 先走
            for (int i=0;i<len1-len2;i++){
                headA = headA.next;
            }
        }else{
            for (int i=0;i<len2-len1;i++){
                headB = headB.next;
            }
        }

        //
        while (headA!=null && headB!=null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;

    }


    public int getLength(ListNode node){
        int len = 0;
        while (node != null){
            len++;
            node=node.next;
        }
        return len;
    }


    public ListNode getIntersectionNode_v2(ListNode headA, ListNode headB) {
        // 第一个指针先遍历链表A在遍历链表B
        // 第二个指针相反
        // 如果有重复节点，两者走的路程互补
        // 如果没有两个走完全程后同时达到NULL
        // 然后return
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2){
            node1 = node1!=null?node1.next:headB;
            node2 = node2!=null?node2.next:headA;
        }
        return node1;
    }
}
