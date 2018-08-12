package company.src.Netease;

import java.util.Arrays;
import java.util.Scanner;
/*
5
2 7 3 4 9
3
1 25 11
 */
// pass 50%  TimeOut
public class main1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int heapNum = input.nextInt();
        int[] appleNumOfEachHeap = new int[heapNum];
        long[] sumOfApple = new long[heapNum];
        Arrays.fill(sumOfApple, 0);
        for (int i = 0; i < heapNum; i++) {
            appleNumOfEachHeap[i] = input.nextInt();
            if(i==0) {
                sumOfApple[i] = appleNumOfEachHeap[i];
            }else{
                sumOfApple[i] += sumOfApple[i - 1] + appleNumOfEachHeap[i];
            }
        }
        int askCount = input.nextInt();
        int[] askedNums = new int[askCount];
        for (int i = 0; i < askCount; i++) {
            askedNums[i] = input.nextInt();
        }
        for (int i = 0; i < askCount; i++) {
            System.out.println(binarySearch(sumOfApple, askedNums[i]));
        }
    }


    public static int binarySearch(long[] arr, int x) {
        if(x < 1 || x > arr[arr.length-1]){
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if(x == arr[middle] || (middle==0&& x<= arr[middle])){
                return middle+1;
            }
            else{
                if(middle-1 > 0){
                    if (x > arr[middle-1] && x<=arr[middle]) {
                        return middle + 1;
                    }
                    else if (x <= arr[middle-1]) {
                        high = middle - 1;
                    } else {
                        low = middle + 1;
                    }
                }
                else{
                    System.out.println("low:"+low+"   high:"+high+"    middle"+middle);
                }
            }
        }
        return -1;
    }
}
