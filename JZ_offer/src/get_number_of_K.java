/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class get_number_of_K {
    public static void main(String[] args){
        int array[] = {1,2,3,3,3,3,4,5};
        int result = new get_number_of_K().GetNumberOfK(array,3);
        System.out.println(result);
    }

    //二分查找：找到第一个k和最后一个k的index
    public int GetNumberOfK(int [] array , int k) {
        int len = array.length;
        if(len<=0)
            return 0;
        int first_K = getFilstK(array, k, 0, len-1);
        int last_K = getLastK(array, k, 0, len-1);
        if(first_K!=-1 && last_K!=-1){
            return last_K-first_K+1;
        }
        return 0;
    }

    //递归写法
    public int getFilstK(int[] array, int k, int start, int end){
        if(start > end) return -1;
        int mid = (start+end)/2;
        if(array[mid] > k){
            return getFilstK(array, k, start, mid-1);
        }else if(array[mid] < k){
            return getFilstK(array, k, mid+1, end);
        }else if(mid-1>=0 && array[mid-1]==k){
            return getFilstK(array, k, start, mid-1);
        }else{
            return mid;
        }
    }

    //循环写法
    private int getLastK(int[] array, int k, int start, int end) {
        int len = array.length;
        while(start <= end){
            int mid = (start + end) >> 1;
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1<len && array[mid+1]==k){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

}
