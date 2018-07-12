import java.util.Stack;

/**
 * 链表中倒数第 k 个节点：
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 总结：倒数第k个问题：注意代码的完整性，考虑问题全面
 *  1.利用栈的先进后出特性
 *  2.使用两个指针，第一个先走 k-1步，再一起走k步
 */
public class find_kth_to_tail {
    public static void main(String[] args){
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next = new ListNode(6);
        ListNode result = new find_kth_to_tail().FindKthToTail(listNode, 2);
        System.out.println(result.val);

    }

    // 思路如下：两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。
    // 然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null || k<=0){
            return null;
        }
        ListNode first = head;
        ListNode last = head;
        for (int i = 1; i < k; i++) {
            //如果节点个数小于所求的倒数第k个节点，则返回空
            if(first.next!=null){
                first = first.next;
            }
            else{
                return null;
            }
        }
        while(first.next!=null){
            first = first.next;
            last = last.next;
        }
        return last;

    }


    //法一：使用栈，但是注意代码完整性问题，考虑问题要全面
    /*
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null || k<=0)
            return null;
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        for (int i = 1; i < k; i++) {
            //eg:{1,2,3,4,5},6
            if(!stack.empty()){
                stack.pop();
            }
            else{
                return null;
            }
        }

        if(!stack.empty()){
            return stack.pop();
        }
        else{
            return null;
        }
    }
    */
}
