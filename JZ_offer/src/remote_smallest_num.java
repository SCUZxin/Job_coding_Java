/**
 * 旋转数组的最小数字：
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class remote_smallest_num {
    public static void main(String[] args){
        int[] array = {3,4,5,1,2};
        int result = new remote_smallest_num().minNumberInRotateArray(array);
        System.out.println(result);
    }

//    public int minNumberInRotateArray(int [] array) {
//        int len = array.length;
//        if(len == 0)
//            return 0;
//
//        int pre = 0;
//        int min = array[0];
//        for (int i = 0; i < len-1; i++) {
//            if(array[i] < pre){
//                min = array[i];
//            }
//            pre = array[i];
//        }
//        return min;
//    }

    //采用二分法解答这个问题
    public int minNumberInRotateArray(int [] array) {
        int len = array.length;
        if(len == 0)
            return 0;
        int low = 0;
        int high = len - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }
            else if(array[mid] == array[high]){
                low = mid + 1;
                //high = high - 1;  //也可以
            }
            else{
                high = mid;
            }
        }
        return array[low];
    }

}
