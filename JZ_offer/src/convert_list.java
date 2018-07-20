/**
 * 二叉搜索树与双向链表:
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class convert_list {
    public static void main(String[] args){

    }

    //直接用中序遍历
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    public void ConvertSub(TreeNode pRootOfTree){
        if(pRootOfTree == null)
            return;
        ConvertSub(pRootOfTree.left);
        if(head == null){
            head = pRootOfTree;
            realHead = head;
        }else{
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
}
