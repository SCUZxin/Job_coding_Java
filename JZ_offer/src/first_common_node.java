import java.util.HashMap;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class first_common_node {
    public static void main(String[] args){
        ListNode lnode1 = new ListNode(2);
        lnode1.next = new ListNode(5);
        lnode1.next.next = new ListNode(9);
        ListNode lnode2 = new ListNode(3);
        lnode2.next = new ListNode(5);
        lnode2.next.next = new ListNode(9);
        ListNode result = new first_common_node().FindFirstCommonNode(lnode1, lnode2);
        System.out.println(result.val);
    }


    //方法一：运用HasnMap的特性
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;

        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        while(current1 != null){
            hashMap.put(current1, null);
            current1 = current1.next;
        }
        while(current2 != null){
            if(hashMap.containsKey(current2)){
                return current2;
            }
            current2 = current2.next;
        }
        return null;
    }

}
