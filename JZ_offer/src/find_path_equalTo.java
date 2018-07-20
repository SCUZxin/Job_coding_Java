import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径：
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class find_path_equalTo {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(2);

        ArrayList<ArrayList<Integer>> retList = new find_path_equalTo().FindPath(root, 10);

        //使用Lambda表达式循环输出
        retList.forEach(
                x ->
                {
                    x.forEach(y-> System.out.print(y+" "));
                    System.out.println();
                });


        //过滤，找到等于5的个数
        retList.forEach(a->{
            System.out.println(a.stream().filter(x->x.equals(5)).count());});

//        for (int i = 0; i < retList.size(); i++) {
//            for (int j = 0; j < retList.get(i).size(); j++) {
//                System.out.print(retList.get(i).get(j)+" ");
//            }
//            System.out.println();
//        }
    }



    //法二：递归
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath_1(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath_1(root.left, target);
        FindPath_1(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }




    //法一: 采用DFS
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> retLists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        DFS(retLists, list, root, target);

        return retLists;
    }

    public void DFS(ArrayList<ArrayList<Integer>> retLists, ArrayList<Integer> list, TreeNode node, int target){
        if(node == null){
            return;
        }
        if(node.left==null && node.right==null){
            if(target == node.val){
                list.add(node.val);
                retLists.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            return;
        }

        list.add(node.val);
        DFS(retLists, list, node.left, target-node.val);
        DFS(retLists, list, node.right, target-node.val);
        list.remove(list.size()-1);
    }
}
