import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class print_linkedList_tail2head {
    public static void main(String[] args){
        ListNode ln = new ListNode(2);
        ln.next = new ListNode(5);
        ln.next.next = new ListNode(9);
        ArrayList<Integer> result = new print_linkedList_tail2head().printListFromTailToHead(ln);
        System.out.println(result);
    }

    // 法一：借助栈的先进后出特性
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        if(listNode == null){
//            return null;
//        }
//        Stack<Integer> stack = new Stack();
//        while(listNode != null){
//            stack.push(listNode.val);
//            listNode = listNode.next;
//        }
//        ArrayList<Integer> ret = new ArrayList<>();
//        while(!stack.empty()){
//            ret.add(stack.pop());
//        }
//        return ret;
//    }

    //法二：递归
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
