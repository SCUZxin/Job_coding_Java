package company.src.ByteDance4;

import java.util.Scanner;

/*

 */
public class main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strT = input.nextLine().trim().split("\\s+");
        int M = Integer.parseInt(strT[0]);
        int N = Integer.parseInt(strT[1]);
        int K = Integer.parseInt(strT[2]);
        String[] str = input.nextLine().split("\\s+");
//        System.out.println("str[]:"+str[0]);
        char [][] ch = new char[N][M];
        for (int i = 0; i < N; i++) {
            String[] chtemp = input.nextLine().split("\\s+");
            for (int j = 0; j < M; j++) {
                ch[i][j] = chtemp[j].charAt(0);
            }
        }

        boolean find = false;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(str[i].charAt(0)==ch[j][k]){
                        if(findWord(str[i], ch, N, M, j, k, 1)){
                            find = true;
                        }
                    }
                }
            }
            if(find){
                System.out.println(str[i]);
                find = false;
            }
        }
//        System.out.println(Arrays.toString(ch[0]));
//        System.out.println();
    }

    public static boolean findWord(String word, char[][] ch, int N, int M, int row, int column, int index) {
        if(index == word.length()){
            return true;
        }
        boolean top=false, bottom=false, left=false, right=false;
        if(row-1>=0 && ch[row-1][column] == word.charAt(index)){
            top = findWord(word, ch, N, M, row-1, column, index+1);
        }
        if(row+1<N && ch[row+1][column] == word.charAt(index)){
            bottom = findWord(word, ch, N, M, row+1, column, index+1);
        }
        if(column-1>=0 && ch[row][column-1] == word.charAt(index)){
            left = findWord(word, ch, N, M, row, column-1, index+1);
        }
        if(column+1<M && ch[row][column+1] == word.charAt(index)){
            right = findWord(word, ch, N, M, row, column+1, index+1);
        }
        return top||bottom||left||right;
    }

}
