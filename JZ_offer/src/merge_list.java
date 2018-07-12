/**
 * 合并两个排序的链表：
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class merge_list {
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(5);
        listNode1.next.next.next = new ListNode(8);
        listNode1.next.next.next.next = new ListNode(14);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);
        listNode2.next.next = new ListNode(7);
        listNode2.next.next.next = new ListNode(10);
        listNode2.next.next.next.next = new ListNode(13);

        ListNode result = new merge_list().Merge(listNode1, listNode2);
        while(result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }

    }

    //法二：非递归
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null && list2==null){
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode mergehead = null;
        ListNode cur = null;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                if(mergehead == null){
                    cur = list1;
                    mergehead = cur;
                }else{
                    cur.next = list1;
                    cur = cur.next;
                }
                list1 = list1.next;
            }
            else{
                if(mergehead == null){
                    cur = list2;
                    mergehead = cur;
                }else{
                    cur.next = list2;
                    cur = cur.next;
                }
                list2 = list2.next;
            }
        }
        if(list1!=null){
            cur.next = list1;
        }
        else{
            cur.next = list2;
        }
        return mergehead;
    }


    //法一：递归
    /*
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null && list2==null){
            return null;
        }
        else if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        else{
            if(list1.val <= list2.val){
                list1.next = Merge(list1.next, list2);
                return list1;
            }else{
                list2.next = Merge(list1, list2.next);
                return list2;
            }

        }
    }
    */
}
