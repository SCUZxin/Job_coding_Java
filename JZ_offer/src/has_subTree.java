/**
 * 树的子结构：
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class has_subTree {
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);

        boolean result = new has_subTree().HasSubtree(root1, root2);
        System.out.println(result);
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root2==null||root1==null)
            return false;
        //当Tree1和Tree2都不为null的时候，才进行比较。否则直接返回false
        else{
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为为起点判断是否包含Tree2
               result = doesTree1HasTree2(root1, root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if(!result){
                result = HasSubtree(root1.left, root2);
            }
            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if(!result){
                result = HasSubtree(root1.right, root2);
            }
            return result;
        }

    }

    private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        // Tree2遍历完了，Tree1 还没有遍历完
        if(root2==null)
            return true;
        // Tree1遍历完了，Tree2 还没有遍历完
        if(root1==null)
            return false;
        // 如果其中有一个点没有对应上，返回false
        if(root1.val != root2.val)
            return false;
        return doesTree1HasTree2(root1.left,root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }
}

class TreeNode{
    TreeNode left=null;
    TreeNode right=null;
    int val=0;
    public TreeNode(int val){
        this.val=val;
    }
}
