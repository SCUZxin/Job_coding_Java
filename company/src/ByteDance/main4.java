package company.src.ByteDance;

import java.util.*;

public class main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] temporary = new int[n];
        for (int i=0;i<n;i++){
            temporary[i] = sc.nextInt();
        }

        int array[] = new int[n*t];
        for (int i =0;i<t*n;i++){
            array[i] = temporary[i%(temporary.length)];
        }

        int result = func1(array);
        System.out.println(result);
    }
    public static int func1(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        return func1Helper(arr, arr.length);
    }

    private static int func1Helper(int[] arr, int length){
        int lis[] = new int[length];
        for(int i = 0; i < length; i++)
            lis[i] = 1;
        for(int i = 1; i < length; i++) {
            for(int j = 0; j < i; j++)
            {
                if(arr[i] > arr[j] && lis[j] + 1 > lis[i])
                    lis[i] = lis[j] + 1;
            }
        }
        int max = lis[0];
        for(int i = 1; i < length; i++)
            if(max < lis[i])
                max = lis[i];
        return max;
    }

}