package company.src.ByteDance3;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        int[][] teamMatrix = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                teamMatrix[i][j] = input.nextInt();
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if(teamMatrix[i][j] == 1){
                    teamMatrix[i][j] = 0;
                    count++;
                    findPartner(M, teamMatrix, i, j);
                }
            }
        }
        System.out.println(count);
    }
    
    public static void findPartner(int M, int[][] teamMatrix, int row, int column){
        for (int i = row+1; i < M; i++) {
            if(teamMatrix[i][column] == 1){
                teamMatrix[i][column] = 0;
                findPartner(M, teamMatrix, i, column);
            }
        }
        for (int j = column+1; j < M; j++) {
            if(teamMatrix[row][j] == 1){
                teamMatrix[row][j] = 0;
                findPartner(M, teamMatrix, row, j);
            }
        }
    }
}
