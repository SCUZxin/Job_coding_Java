import java.util.*;

/**
 * 数组中只出现一次的数字：
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class find_nums_appearOnce {
    public static void main(String[] args){
        int[] array = {1,2,3,4,1,2,9,4};
        int[] num1 = {0};
        int[] num2 = {0};
        new find_nums_appearOnce().FindNumsAppearOnce(array, num1, num2);
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        List<Integer> list = new ArrayList<>();

        for (Integer num: array) {
            if(list.contains(num)){
                list.remove(num);
                System.out.println("remove "+num+" :"+list.toString());
            }else{
                list.add(num);
                System.out.println("add "+num+" :"+list.toString());
            }
        }

        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }
}
