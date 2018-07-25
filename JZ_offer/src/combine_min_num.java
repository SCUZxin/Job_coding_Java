import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数：
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3,32,321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class combine_min_num {
    public static void main(String[] args){
        int[] array = {3,5,1,4,2};
        String result = new combine_min_num().PrintMinNumber(array);
        System.out.println(result);
    }


    //法二：先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
    public String PrintMinNumber(int [] numbers) {
        String str = "";
        int len = numbers.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1+""+o2;
                String s2 = o2+""+o1;
                return s1.compareTo(s2);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i);
        }

        return str;
    }



    //法一：方法同字符串的排列, 但耗时较长
    public String PrintMinNumber_1(int [] numbers) {
        ArrayList<String> list = new ArrayList<>();
        if(numbers.length <= 0)
            return "";
        else if(numbers.length == 1)
            return String.valueOf(numbers[0]);
        else{
            minNumHelper(list, numbers, 0);
        }

        ArrayList<Long> retList = new ArrayList<>();
        list.forEach(x -> {
            retList.add(Long.parseLong(x));
        });
        Collections.sort(retList);

        return retList.get(0).toString();
    }

    public void minNumHelper(ArrayList<String> list, int [] numbers, int i){
        if(i == numbers.length-1){
            String val = "";
            for (Integer x: numbers) {
                val += x;
            }
            System.out.println("val: "+val);
            if (!list.contains(val)){
                list.add(val);
            }
        }
        else{
            for (int j = i; j < numbers.length; j++) {
                swap(numbers, i, j);
                minNumHelper(list, numbers, i+1);
                swap(numbers, i, j);
            }
        }
    }

    public void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
