/**
 * 删除链表中重复的节点：
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DelDuplicationNode {

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        ListNode result = new DelDuplicationNode().deleteDuplication(node);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null || pHead.next==null){
            return pHead;
        }

        //当前节点是重复节点
        if(pHead.val == pHead.next.val){
            ListNode pNode = pHead.next;
            while(pNode!=null && pNode.val==pHead.val){
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        }
        //当前节点不是重复节点
        else{
            // 保留当前结点，从下一个结点开始递归
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
