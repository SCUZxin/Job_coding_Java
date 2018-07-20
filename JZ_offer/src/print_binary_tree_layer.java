import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 从上往下打印二叉树：
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class print_binary_tree_layer {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);

        ArrayList<Integer> result = new print_binary_tree_layer().PrintFromTopToBottom(root);
        result.forEach(i -> System.out.print(i+" "));
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> retList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            retList.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return retList;
    }
}
