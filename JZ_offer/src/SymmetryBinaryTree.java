/**
 * 对称的二叉树：
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetryBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.left.right = new TreeNode(4);

        boolean result = new SymmetryBinaryTree().isSymmetrical(root);
        System.out.println(result);
    }

    /* 思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
     * 左子树的右子树和右子树的左子树相同即可，采用递归
     * 非递归也可，采用栈或队列存取各级子树根节点
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        return isSymmetricalHelper(pRoot.left, pRoot.right);

    }

    private boolean isSymmetricalHelper(TreeNode left, TreeNode right){
        if(left == null){
            return right==null;
        }
        //左子树不空，右子树为空
        if(right == null){
            return false;
        }
        //左右子树都不为空
        //1.值不相等
        if(left.val != right.val) {
            return false;
        }
        //2.值相等
        return isSymmetricalHelper(left.right, right.left) && isSymmetricalHelper(left.left, right.right);
    }
}
