package company.src.PinDuoDuo;

import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine().trim();
        char[] cs = str.toCharArray();
        int K = cs.length/4;
        print(cs, K);
    }

    public static void print(char[] cs, int K){
        char[][] out = new char[K+1][K+1];
        for (int i = 0; i < K+1; i++) {
            for (int j = 0; j < K+1; j++) {
                out[i][j] = ' ';
            }
        }
        int index = 0;//标记cs数组当前取到第几个值
        //第一行从左到右
        for (int j = 0; j < K+1; j++) {
            out[0][j] = cs[index++];
        }
        //右边从上到下
        for (int i = 1; i < K+1; i++) {
            out[i][K] = cs[index++];
        }
        //下边从右到左
        for (int j = K-1; j >= 0; j--) {
            out[K][j] = cs[index++];
        }
        //左边从下到上
        for (int i = K-1; i >= 1; i--) {
            out[i][0] = cs[index++];
        }
        for (int i = 0; i < K+1; i++) {
            for (int j = 0; j < K+1; j++) {
                System.out.print(out[i][j]);
            }
            System.out.println();
        }
    }

}
