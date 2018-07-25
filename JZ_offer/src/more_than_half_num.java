/**
 * 数组中出现次数超过一半的数字：
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在
 * 数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 该问题考察时间效率问题， 注意时间复杂度
 */
public class more_than_half_num {
    public static void main(String[] args){
        int[] array = {1,2,3,2,2,2,5,4,2};
        int result = new more_than_half_num().MoreThanHalfNum_Solution(array);
        System.out.println(result);
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        int num = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i] == num){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                num = array[i];
                count = 1;
            }
        }

        // Verifying
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == num)
                count++;
        }
        if(count*2 > array.length)
            return num;
        else{
            return 0;
        }
    }
}
