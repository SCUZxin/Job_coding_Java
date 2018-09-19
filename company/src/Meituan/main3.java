package company.src.Meituan;

import java.util.Scanner;

/**
 * 阿里编程测验题
 */
public class main3 {

    static int minpath = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        //点的集合
        int[][] route = new int[N][2];
        for(int i = 0; i < N; i++){
            route[i][0] = input.nextInt();
            route[i][1] = input.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            minpath = Math.min(findPath(0, i, route, N, 0), minpath);
        }
        System.out.println(N);
    }

    public static int findPath(int index, int start, int[][] route, int N, int retCount){
        for (int i = index; i < N; i++) {
            if(route[i][0] == start){
                retCount++;
                findPath(index++, start, route, N, retCount);

                findPath(index++, route[i][1], route, N, retCount);
            }
        }

        return minpath;
    }
}

