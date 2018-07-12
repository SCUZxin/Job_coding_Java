import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 反转链表：
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class reverse_list {
    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next = new ListNode(6);
        ListNode result = new reverse_list().ReverseList(listNode);
        System.out.println(result.next.next.val);

    }

    //法二：推荐法二
    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        ListNode pre = null;
        ListNode next = null;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        while(head!=null){
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.next = pre;
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;
            head = next;
        }
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;
    }


    //法一
    /*
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        while(head!=null){
            queue.offer(head.val);
            head = head.next;
        }
        ListNode cur = new ListNode(queue.poll());
        ListNode ret = cur;
        while(!queue.isEmpty()){
            cur = new ListNode(queue.poll());
            cur.next = ret;
            ret = cur;
        }

        return ret;
    }
    */
}
