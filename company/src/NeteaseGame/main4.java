package company.src.NeteaseGame;

import java.util.Scanner;

/*
3
3
3 3
3 3
3 3
3
1 1
2 2
3 3
3
3 4
2 3
1 2

1
3
2 2
2 2
2 2
 */

public class main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int[] N = new int[T];
        int[][][] matrix = new int[T][][];
        for (int i = 0; i < T; i++) {
            N[i] = input.nextInt();
            matrix[i] = new int[N[i]][2];
            for (int j = 0; j < N[i]; j++) {
                matrix[i][j][0] = input.nextInt();
                matrix[i][j][1] = input.nextInt();
            }
        }

//        System.out.println();
        for (int i = 0; i < T; i++) {
            System.out.println(isValid(N[i], matrix[i]));
//                System.out.print(matrix[i][j][0]);
//                System.out.print(matrix[i][j][1]);
//                System.out.println();

        }
    }

    public static String isValid(int N, int[][] matrix){
        int [] visited = new int[N];
        for (int i = 0; i < N; i++) {
            visited[i]=1;
            if(DFS(N, i, matrix, visited, 1)){
                return "yes";
            }
            visited[i]=0;
        }
        return "no";
    }
    public static boolean DFS(int N, int index, int[][] matrix, int[] visited, int num){
        if(num == N){
            return true;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i]==0 && matrix[i][0] == matrix[index][1]){
                visited[i]=1;
                if(DFS(N, i, matrix, visited, num+1)){
                    return true;
                }
                visited[i]=0;
            }
        }
        return false;
    }

}
