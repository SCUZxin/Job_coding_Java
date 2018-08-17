

/**
 * 序列化二叉树：
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class BinaryTreeSerializer {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        String serializeTree = new BinaryTreeSerializer().Serialize(root);
        System.out.println(serializeTree);
        TreeNode deserializeTree = new BinaryTreeSerializer().Deserialize(serializeTree);
        System.out.println(deserializeTree.left.right.val);
    }

    // 序列化：使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点不为空时，
    // 在转化val所得的字符之后添加一个' ， '作为分割。对于空节点则以 '#' 代替。
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }


    int index=-1;//表示分割之后的字符数组的下标
    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        String[] strArray = str.split(",");
        TreeNode node = null;
        if(!"#".equals(strArray[index])){
            node = new TreeNode(Integer.valueOf(strArray[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
