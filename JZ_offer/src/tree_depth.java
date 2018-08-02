import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度：
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class tree_depth {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(8);

        int result = new tree_depth().TreeDepth(root);
        System.out.println(result);
    }

    //法一：递归法
    public int TreeDepth_1(TreeNode root) {
        if(root == null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right)+1;
    }

    //法二：层序遍历
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count=0, depth=0, nextCount=1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(count == nextCount){
                count = 0;
                nextCount = queue.size();
                depth += 1;
            }

        }
        return depth;
    }
}
