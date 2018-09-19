package company.src.JD;

import java.util.Scanner;

/**
 * 题目描述：
 现有n个物品，每个物品有三个参数 ai , bi , ci ，定义i物品不合格品的依据是 : 若存在物品 j , 且aj>ai , bj>bi , cj>ci，则称i物品为不合格品。
 现给出n个物品的a,b,c参数，请你求出不合格品的数量。
 输入：
 第一行包含一个整数n(1<=n<=500000),表示物品的数量。接下来有n行，每行有三个整数，ai,bi,ci表示第i个物品的三个参数，1≤ai,bi,ci≤109。
 输出：输出包含一个整数，表示不合格品的数量。
 样例输入
 3
 1 4 2
 4 3 2
 2 5 3
 样例输出
 1

 样例解释
 物品1的a,b,c均小于物品3的a,b,c,因此1为不合格品。
 */
public class main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] paras = new int[n][3];
        for (int i = 0; i < n; i++) {
            paras[i][0] = input.nextInt();
            paras[i][1] = input.nextInt();
            paras[i][2] = input.nextInt();
        }
        int countBad = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isBad(i, j, paras)) {
                    countBad++;
                    break;
                }
            }
        }
        System.out.println(countBad);
    }

    private static boolean isBad(int i, int j, int[][] paras) {
        boolean flag = false;
        if (paras[i][0] < paras[j][0] && paras[i][1] < paras[j][1] && paras[i][2] < paras[j][2]) {
            flag = true;
        }
        return flag;

    }
}

