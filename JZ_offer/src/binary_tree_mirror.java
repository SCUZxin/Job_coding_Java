import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树的镜像：
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class binary_tree_mirror {

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        new binary_tree_mirror().LayerOrder(root1);
        System.out.println();
        new binary_tree_mirror().Mirror(root1);

        new binary_tree_mirror().LayerOrder(root1);
    }

    //层序遍历
    public void LayerOrder(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;

            // 叶子节点不用交换，减少交换时间
            if(root.left != null || root.right!=null) {
                Mirror(root.left);
                Mirror(root.right);
            }
        }
    }
}
