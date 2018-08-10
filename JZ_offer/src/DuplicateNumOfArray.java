import java.util.ArrayList;
import java.util.List;

/**
 * 数组中重复的数字;
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class DuplicateNumOfArray {
    public static void main(String[] args){
        int[] numbers = {2,1,3,1,4};
        int length = numbers.length;
        int[] dulplication = new int[1];
        boolean result = new DuplicateNumOfArray().duplicate(numbers, length, dulplication);
        System.out.println(dulplication[0]);
        System.out.println(result);
    }


    //法二：不需要额外的数组或者hash table来保存，题目里写了数组里数字的范围保证在0 ~ n-1 之间，
    // 所以可以利用现有数组设置标志，当一个数字被访问过后，可以设置对应位上的数 + n，
    // 之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            if(index >= length){
                index -= length;
            }
            if(numbers[index] >= length){
                duplication[0] = numbers[i]%length;
                return true;
            }
            numbers[index] = numbers[index] + length;
        }
        return false;
    }


    //法一：需要额外的数组或者hash table 来保存
    public boolean duplicate_1(int numbers[],int length,int [] duplication) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if(numList.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }
            numList.add(numbers[i]);
        }
        return false;
    }
}
