/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class re_order_array {

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        new re_order_array().reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    //方法一：类似冒泡算法，前偶后奇数就交换
    /*
    public void reOrderArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(isEven(array[j]) && !isEven(array[j+1])){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    */

    // 方法二：再创建一个数组,
    // 奇数从前往后遍历并存入从前开始新数组，偶数从后往前遍历并从后开始存入新数组;
    // 或者先计算奇数的个数oddCount，从begin开始存放奇数，然后从oddCount处开始存放偶数
    public void reOrderArray(int [] array){
        int[] array2 = new int[array.length];
        for (int i = 0,j=0; i < array.length; i++) {
            if(!isEven(array[i])){
                array2[j++] = array[i];
            }
        }

        for (int i = array.length-1,j=array.length-1; i >= 0; i--) {
            if(isEven(array[i])){
                array2[j--] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = array2[i];
        }
    }


    boolean isEven(int n){
        return n%2 == 0;
    }
}
