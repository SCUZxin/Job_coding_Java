package Meituan;

import java.util.Scanner;

/**
 * n以内的正整数一共有多少位数字。不统计前导零。
 * 例如：n为13时，12345678910111213，共17位，则输出为17。
 */
public class main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int T =sc.nextInt();
            int n=0;
            long[] result = new long[T];
            for(int i=0;i<T;i++) {
                n = sc.nextInt();
                result[i] = numCount(n);
            }
            for(int i=0;i<T;i++) {
                System.out.println(result[i]);
            }
        }
    }

    public static long numCount(long n){
        int count = 0;
        if(n<=9)
            return n;
        if(n == 1000000000)
            return 8888888889L+10;

        for(int i=1;i<=9;i++){
            if(n>=Math.pow(10,i)){
                count += 9*Math.pow(10,i-1)*(i);
            }else{
                count += (n-Math.pow(10,i-1)+1)*(i);
                break;
            }
        }
        return count;
    }

}
