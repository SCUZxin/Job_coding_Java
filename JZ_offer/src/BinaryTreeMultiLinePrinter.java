import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 把二叉树打印成多行：
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class BinaryTreeMultiLinePrinter {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> result = new BinaryTreeMultiLinePrinter().Print(root);
        System.out.println(result.toString());
    }


    // 思路：利用队列进行层序遍历,laySize 和 for循环进行每一层的遍历
    ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> retLists = new ArrayList<>();
        if(pRoot == null){
            return retLists;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(pRoot);
        ArrayList<Integer> layerList;
        while(!queue.isEmpty()){
            layerList = new ArrayList<>();
            int laySize = queue.size();
            for (int i = 0; i < laySize; i++) {
                TreeNode node = queue.poll();
                layerList.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            retLists.add(layerList);
        }
        return retLists;
    }
}
