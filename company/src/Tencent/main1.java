package company.src.Tencent;

import java.util.Arrays;
import java.util.Scanner;

/*

 */

public class main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = input.nextInt();
        }
        int K = input.nextInt();
        System.out.println(maxAbs(array, K, N));

    }

    public static int maxAbs(int[] nums, int K, int N) {
        int[] retArray = new int[N];
        for (int i = 0; i < N; i++) {
            retArray[i] = nums[i];
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            if(nums[i]<0){
                max = Math.max(max, nums[i]);
                nums[i] = -nums[i];
            }
        }
        for (int i = 0; i < N; i++) {
            if(retArray[i]<max){
                retArray[i] = -retArray[i];
            }
        }

        int maxVal = 7;

        for (int i = 0; i < N; i++) {
//            return 0;
        }

        return maxVal;
    }

}
