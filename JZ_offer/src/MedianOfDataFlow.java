import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数：
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class MedianOfDataFlow {
    public static void main(String[] args){
        int[] dataFlow = {5,2,3,4,1,6,7,0,8};
        MedianOfDataFlow medianOfDataFlow = new MedianOfDataFlow();
        for (int i = 0; i < dataFlow.length; i++) {
            medianOfDataFlow.Insert(dataFlow[i]);
            System.out.println(medianOfDataFlow.GetMedian());
        }
    }

    //记录数据个数
    private int count=0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    // 解题思路就是用两个堆，一个大顶堆，一个小顶堆来过滤数据。
    // 大根堆储存小数据，小根堆储存大数据
    public void Insert(Integer num) {
        //当数据总数为偶数时，新加入的元素，应当进入小根堆
        //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
        if(count%2 == 0){
            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(maxHeap.poll());
        }
        //当数据总数为奇数时，新加入的元素，应当进入大根堆
        //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
        else{
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            //2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(minHeap.poll());
        }
        count++;
    }

    public Double GetMedian() {
        //要用peek(), 不能用poll()
        if(count%2 == 0){
            return new Double((minHeap.peek()+maxHeap.peek()))/2;
        }
        else{
            return new Double(minHeap.peek());
        }
    }

}
