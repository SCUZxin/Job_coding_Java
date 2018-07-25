import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的 K 个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

/*
 *基于堆排序算法，构建最大堆。时间复杂度为O(nlogk)
 *如果用快速排序，时间复杂度为O(nlogn)；
 *如果用冒泡排序，时间复杂度为O(n*k)
 */
public class least_numbers {
    public static void main(String[] args){
        int[] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = new least_numbers().GetLeastNumbers_Solution(input, 4);
        System.out.println(result.toString());
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        int len = input.length;
        if(k > len || k == 0){
            return ret;
        }

        //最大堆的实现（默认是最小堆），k是最大堆的容量
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < len; i++) {
            if(maxHeap.size() != k){
                maxHeap.offer(input[i]);
            }
            else if(input[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }

        maxHeap.forEach(x -> ret.add(x));

        return ret;
    }
}
