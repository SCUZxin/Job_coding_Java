import java.util.ArrayList;

/**
 * 滑动窗口的最大值：
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInSlideWindows {
    public static void main(String[] args){
        int[] array = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> result = new MaxInSlideWindows().maxInWindows(array, 3);
        System.out.println(result.toString());

    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> retList = new ArrayList<>();
        if(num.length==0 || size<=0 || size>num.length){
            return retList;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        //第一轮找到最大值及其下标
        for (int i = 0; i < size; i++) {
            if(num[i] >= max){
                max = num[i];
                maxIndex = i;
            }
        }
        retList.add(max);

        if(num.length-size >= 1) {
            //第1+轮
            for (int i = 1; i < num.length - size + 1; i++) {
                //最大值下标不是前一轮的第一个值
                if (maxIndex != i - 1) {
                    //只需比较该轮最后一个值和最大值
                    if (num[i + size - 1] >= max) {
                        max = num[i + size - 1];
                        maxIndex = i + size - 1;
                    }
                }
                //最大值下标是前一轮的第一个值
                else {
                    max = Integer.MIN_VALUE;
                    maxIndex = -1;
                    //轮询重新找出最大值
                    for (int j = i; j < i + size; j++) {
                        if (num[j] >= max) {
                            max = num[j];
                            maxIndex = j;
                        }
                    }
                }
                retList.add(max);
            }
        }
        return retList;
    }

}
