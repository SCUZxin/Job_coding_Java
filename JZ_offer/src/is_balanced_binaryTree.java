/**
 * 平衡二叉树：
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class is_balanced_binaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(8);

        boolean result = new is_balanced_binaryTree().IsBalanced_Solution(root);
        System.out.println(result);
    }

    /**
     * 在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
     * 如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
     * 如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
     * @param root
     * @return
     */
    boolean isBalance = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalance;
    }

    public int getDepth(TreeNode node){
        if(node == null)
            return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if(Math.abs(left-right) > 1){
            isBalance = false;
        }
        return Math.max(left, right) + 1;
    }

}
