package IQiYi;

import java.util.Scanner;

/**
 * A、B、C相等最少操作次数：
 * 1. 三选二 加1
 * 2. 三选一 加2
 */
public class main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            System.out.println(minOperate(A,B,C));
        }
    }

    public static int minOperate(int A, int B, int C){
        int max = Math.max(Math.max(A,B),C);//找到A、B、C中最大值，操作另外两个等于第三个
        int p = 0;
        int q = 0;
        if(max == A){
            p=B;q=C;
        }else if(max == B){
            p=A;q=C;
        }else if(max==C){
            p=A;q=B;
        }

        int dis = max-p+max-q;
        if(dis%2==0){
            return dis/2;
        }else{
            return dis/2+2;
        }
    }
}
