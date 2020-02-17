package offer;

// 两个链表的第一个公共节点
public class FirstPublicNodeOfTwoLinkList {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);

        if (len1 > len2) {
            // 长的先走
            for (int i = 0; i < len1 - len2; i++) {
                pHead1 = pHead1.next;
            }
        }else {
            for (int i = 0; i < len2 - len1; i++) {
                pHead2 = pHead2.next;
            }
        }

        while (pHead1!=null && pHead2!=null && pHead1!=pHead2){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return pHead1;

    }


    public int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}


