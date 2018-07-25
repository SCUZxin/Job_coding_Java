/**
 * 连续子数组的最大和
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * 动态规划：df[i] = max(array[i], df[i-1] + array[i])
 */
public class greatest_sum_subArray {
    public static void main(String[] args){
        int[] array = {6,-3,-2,7,-15,1,2,2};
        int result = new greatest_sum_subArray().FindGreatestSumOfSubArray(array);
        System.out.println(result);
    }

    //动态规划
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int[] df = new int[len];
        //记录当前所有子数组的和的最大值
        int ret = array[0];
        //包含array[i]的连续数组最大值
        df[0] = array[0];
        for (int i = 1; i < len; i++) {
            df[i] = Math.max(array[i], df[i-1]+array[i]);
            ret = Math.max(df[i], ret);
        }
        return ret;
    }

}
