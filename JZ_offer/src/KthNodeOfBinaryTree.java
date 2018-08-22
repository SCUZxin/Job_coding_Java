/**
 * 二叉搜索树的第K个节点：
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如,（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNodeOfBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNode result = new KthNodeOfBinaryTree().KthNode(root, 3);
        System.out.println(result.val);
    }

    int count = 0;//计数器
    //思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null){
            return null;
        }

        TreeNode node = KthNode(pRoot.left, k);
        //在左边找到第k小的值
        if(node!=null){
            return node;
        }

        count++;
        if(count == k) {
            return pRoot;
        }
        node = KthNode(pRoot.right, k);
        if(node!=null){
            return node;
        }
        return null;
    }
}
