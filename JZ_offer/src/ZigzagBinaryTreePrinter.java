import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 按之字形顺序打印二叉树：
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class ZigzagBinaryTreePrinter {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> result = new ZigzagBinaryTreePrinter().Print(root);
        System.out.println(result.toString());
    }


    // 思路：利用队列进行层序遍历,laySize 和 for循环进行每一层的遍历
    // 奇数层直接ArrayList.add(val), 偶数层就ArrayList.add(0, val)
    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> retLists = new ArrayList<>();
        if(pRoot == null){
            return retLists;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(pRoot);
        boolean even = false;
        ArrayList<Integer> layerList;
        while(!queue.isEmpty()){
            layerList = new ArrayList<>();
            int laySize = queue.size();
            for (int i = 0; i < laySize; i++) {
                TreeNode node = queue.poll();
                if(even) {
                    layerList.add(0, node.val);
                }
                else{
                    layerList.add(node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            retLists.add(layerList);
            even = !even;
        }
        return retLists;
    }

}
