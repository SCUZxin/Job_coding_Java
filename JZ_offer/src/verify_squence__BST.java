/**
 * 二叉搜索树的后序遍历：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class verify_squence__BST {
    public static void main(String[] args){
        int[] sequence = {1, 2, 6, 3, 5};
        boolean result = new verify_squence__BST().VerifySquenceOfBST(sequence);
        System.out.println(result);
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)
            return false;
        return isTreeBFS(sequence, 0, sequence.length-1);
    }

    private boolean isTreeBFS(int[] sequence, int start, int end) {
        if(end <= start)
            return true;
        int i=start;
        for (; i < end; i++) {
            if(sequence[i] > sequence[end])
                break;
        }
        int splitIndex = i;
        for (int j = splitIndex; j < end; j++) {
            if(sequence[j] < sequence[end])
                return false;
        }
        return isTreeBFS(sequence, start, splitIndex - 1) && isTreeBFS(sequence, splitIndex, end-1);
    }
}
