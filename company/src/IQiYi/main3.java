package IQiYi;

import java.util.Scanner;

/**
 * n种糖果，盒子要m个糖果，每种糖果的数量有限制（min<= X <=max）
 */
public class main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();// 颜色种类
        int m = scanner.nextInt();// 盒子放置m个糖果
        int[] l = new int[n];
        int[] r = new int[n];
        int least = 0;
        int[] avaliable = new int[n];// 表示每一种颜色剩余可以加的
        for (int i = 0; i < r.length; i++) {
            l[i] = scanner.nextInt();
            r[i] = scanner.nextInt();
            least += l[i];
            avaliable[i] = r[i] - l[i];
        }
        int target = m - least;
        long[][] dp = new long[n + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 0; k <= avaliable[i - 1]; k++) {
                    if (j - k >= 0)
                        dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        System.out.println(dp[n][target]);
    }

}

