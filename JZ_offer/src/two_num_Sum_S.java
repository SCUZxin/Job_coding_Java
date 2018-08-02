import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 和为S的两个数字：
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class two_num_Sum_S {
    public static void main(String[] args){
        int[] array = {2,4,5,8,10,11,15,16};
        int sum = 13;
        ArrayList<Integer> result = new two_num_Sum_S().FindNumbersWithSum(array, sum);
        System.out.println(result.toString());
    }

    //法二：
    //若ai + aj == sum，就是答案（相差越远乘积越小）
    //若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
    //若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i=0,j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if(array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }

        }
        return list;
    }


    //法一
    public ArrayList<Integer> FindNumbersWithSum_1(int [] array, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> retlist = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], 1);
        }
        int Multiply = Integer.MAX_VALUE;
        int tempMul = 0;
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(sum-array[i])){
                tempMul = array[i] * (sum-array[i]);
                if(tempMul < Multiply){
                    Multiply = tempMul;
                    retlist.clear();
                    retlist.add(Math.min(array[i], sum-array[i]));
                    retlist.add(Math.max(array[i], sum-array[i]));
                }
                map.remove(array[i]);
            }
        }
        return retlist;
    }
}
