/**
 * 数组中的逆序对：
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class inverse_pairs {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,0};
        int result = new inverse_pairs().InversePairs(array);
        System.out.println(result);
    }

    //归并排序的思想
    public int InversePairs(int [] array) {
        int len = array.length;
        if(array==null || len ==0)
            return 0;
        int copy[] = new int[len];
        long count = merge(array, copy, 0, len-1);

        return (int)count;
    }

    //归并排序
    public long merge(int [] array, int[]  copy, int low, int high){
        if(low == high){
            return 0;
        }
        int mid = (low + high) >> 1;
        long leftCount = merge(array, copy, low, mid);
        long rightCount = merge(array, copy, mid+1, high);

        int count=0, i=mid, j=high, locCopt=high;
        while(i>=low && j>mid){
            if(array[i]>array[j]){
                count += j-mid;
                copy[locCopt--] = array[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else{
                copy[locCopt--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopt--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopt--] = array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }
}
