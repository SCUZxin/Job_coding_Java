package company.src.Tencent;

import java.util.Arrays;
import java.util.Scanner;

/*
2
4
14 21 94 35
6
10 16 87 43 51 75
 */

public class main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int i=0;
        while(i<t){
            int n = input.nextInt();
            int[] lengthArray = new int[n];
            for (int j = 0; j < n; j++) {
                lengthArray[j] = input.nextInt();
            }
            System.out.println(triangleNumbers(lengthArray));
            i++;
        }
        String str = input.nextLine().trim();

    }

    public static int triangleNumbers(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            System.out.println("k:"+k);
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                System.out.println("k-j"+k+" "+j);
                count += k - j - 1;
            }
        }
        return count;
    }

}
